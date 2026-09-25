import java.util.*;
public class Problem5 {
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }
    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;
        for (int i = 0; i < candidates.length; i++) {
            Candidate candidate = candidates[i];
            if (isEligible(candidate.getCgpa()) || isEligible(candidate.getCgpa(), candidate.getCodingScore())) {
                shortlisted[count] = candidate;
                count++;
            }
        }
        Candidate[] rankedCandidates = Arrays.copyOf(shortlisted, count);
        Arrays.sort(rankedCandidates);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rankedCandidates.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(rankedCandidates[i].getName()).append(" (").append(rankedCandidates[i].getCompositeScore()).append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }
    public String getName() {
        return name;
    }
    public double getCgpa() {
        return cgpa;
    }
    public int getCodingScore() {
        return codingScore;
    }
    public double getCompositeScore() {
        return (cgpa * 10) + (codingScore / 2.0);
    }
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), getCompositeScore());
    }
}