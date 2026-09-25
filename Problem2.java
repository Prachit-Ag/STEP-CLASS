import java.util.*;
public class Problem2 {
   static class Scorecard{
    int max;
    int count = 0;
    private boolean[] answer;
    int pos = 0;
    Scorecard(int max){
        this.max = max;
        this.answer = new boolean[max];
    }
    void recordAnswer(boolean a){
        if (pos >= max){
            return;
        }
        answer[pos] = a;
        pos++;
    }
    int getScore(){
        count = 0;
        for (int i = 0; i < pos; i++){
            if (answer[i]) count++;
        }
        return count;
    }
   }
   public static void main(String[] args) {
    Scorecard sc = new Scorecard(4);
    sc.recordAnswer(true); 
    sc.recordAnswer(true); 
    sc.recordAnswer(false); 
    sc.recordAnswer(true);
    int score = sc.getScore();
    System.out.println("Score: " + score);
   } 
}