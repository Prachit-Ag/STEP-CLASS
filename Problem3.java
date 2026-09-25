import java.util.*;
public class Problem3 {
    static int[] findTopThreeScores(int[] scores){
        int first = 0, second = 0, third = 0;
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }
        return new int[] {first, second, third};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Elements: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i< n; i++){
            System.out.print("Elemets[" + i + "]: ");
            scores[i] = sc.nextInt();
        }
        int[] top = findTopThreeScores(scores);
        System.out.print(Arrays.toString(top));
    }
}
