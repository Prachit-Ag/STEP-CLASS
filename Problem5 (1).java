import java.util.*;
public class Problem5 implements Comparable<Problem5> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;
    public Problem5(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }
    public int compareTo(Problem5 other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(Problem5[] players) {
        Problem5[] draftable = new Problem5[players.length];
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {
                draftable[count] = players[i];
                count++;
            }
        }
        Problem5[] finalDraft = Arrays.copyOf(draftable, count);
        Arrays.sort(finalDraft);
        String result = "";
        for (int i = 0; i < finalDraft.length; i++) {
            result += (i + 1) + ". " + finalDraft[i].name;
            if (i < finalDraft.length - 1) {
                result += " | ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem5[] players = {
            new Problem5("Virat", 15, 48.0, false),
            new Problem5("Rahul", 7, 55.0, false),
            new Problem5("Sameer", 3, 60.0, false),
            new Problem5("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}