import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

abstract class Question {
    protected String text, correctAnswer, studentAnswer;
    protected double points;
    public Question(String text, String correctAnswer, String studentAnswer, double points) {
        this.text = text; this.correctAnswer = correctAnswer; this.studentAnswer = studentAnswer; this.points = points;
    }
    public abstract double evaluate();
    public abstract String getType();
}

class ExactMatchQuestion extends Question {
    private String type;
    public ExactMatchQuestion(String type, String text, String correct, String student, double points) {
        super(text, correct, student, points);
        this.type = type;
    }
    public double evaluate() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }
    public String getType() { return type; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correct, String student, double points) {
        super(text, correct, student, points);
    }
    public double evaluate() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String studentAnsLower = studentAnswer.toLowerCase();
        for (String kw : keywords) {
            if (studentAnsLower.contains(kw.trim().toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0.0;
    }
    public String getType() { return "ESSAY"; }
}

public class GraderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        double totalScore = 0.0;
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Matcher m = pattern.matcher(line);
            List<String> tokens = new ArrayList<>();
            while (m.find()) {
                if (m.group(1) != null) tokens.add(m.group(1));
                else tokens.add(m.group(2));
            }
            
            String type = tokens.get(0);
            String text = tokens.get(1);
            String correct = tokens.get(2);
            String student = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));
            
            Question q = switch (type) {
                case "MCQ", "TF" -> new ExactMatchQuestion(type, text, correct, student, points);
                case "ESSAY" -> new EssayQuestion(text, correct, student, points);
                default -> throw new IllegalArgumentException("Unknown type");
            };
            
            double score = q.evaluate();
            totalScore += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
    }
}