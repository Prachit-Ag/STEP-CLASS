import java.util.*;
public class Problem4 {
    private static double rowAverage(int[] row){
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum += row[i];
        }
        return (double) sum / row.length;
    }
    static String classifyRows(int[][] seatingScores, int threshold){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);
            String zone;
            if (average < threshold) {
                zone = "Quiet Zone";
            } else {
                zone = "Buzzing Zone";
            }
            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ").append(zone);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter Number of Columns: ");
        int columns = sc.nextInt();
        System.out.print("Enter Threshold: ");
        int threshold = sc.nextInt();
        int[][] seatingscores = new int[rows][columns];
        for (int i =0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print("Elements[" + i + "][" + j + "]: ");
                seatingscores[i][j] = sc.nextInt();
            }
        }
       System.out.println(classifyRows(seatingscores, threshold));
       sc.close();
    }
}
