import java.util.*;
public class Problem2{
    static String findDuplicateTeam(String[] teamNames){
        for (int i =0; i < teamNames.length-1; i++){
            for (int j = i+1; j < teamNames.length; j++){
                if (teamNames[i].equals(teamNames[j])){
                    return ("Duplicate Found: " + teamNames[i]);
                }
            }
        }
        return "No Duplicate Found";
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of Elements: ");
    int n = sc.nextInt();
    String[] team = new String[n];
    sc.nextLine();
    for(int i =0; i < n; i++){
        System.out.print("Team[" + (i+1) + "]: ");
        team[i]= sc.nextLine();
    }
    System.out.println(findDuplicateTeam(team));
    sc.close();
    }
}