import java.util.*;
public class Problem1{
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex){
        playerScores[captainIndex] *= 2;
        playerScores[viceCaptainIndex] *= 1.5;
        System.out.println(Arrays.toString(playerScores));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Element: ");
        int n = sc.nextInt();
        double[] playerScores = new double[n];
        for (int  i = 0; i < n ; i++){
            System.out.print("Element[" + (i+1) + "]: ");
            playerScores[i] = sc.nextDouble();
        }
        System.out.print("Enter Capatain Position: ");
        int captain = sc.nextInt();
        System.out.print("Enter Vice-Capatain Position: ");
        int vicecaptain = sc.nextInt();
        applyMultipliers(playerScores, captain, vicecaptain);
        sc.close();
    }
}
