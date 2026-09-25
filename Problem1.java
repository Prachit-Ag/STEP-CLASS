import java.util.*;
public class Problem1{
    static void curveScores(int[] scores, int bonus){
        for (int i = 0; i < scores.length; i++){
            scores[i]+= bonus;
        }
        System.out.println(Arrays.toString(scores));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Elemets: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        System.out.print("Enter Bonus: ");
        int bonus = sc.nextInt();
        for (int i = 0; i < n; i++){
            System.out.print("Element[" + i + "]: ");
            scores[i] = sc.nextInt();
        }
        curveScores(scores, bonus);
        sc.close();
    }
}