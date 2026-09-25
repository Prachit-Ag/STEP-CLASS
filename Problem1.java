import java.util.*;
public class Problem1{
    static class PiggyBank{
        String ID;
        private int amount = 0;
        PiggyBank(String ID){
            this.ID = ID;
        }
        public void deposit(int a){
            amount += a;
            System.out.println("Deposit Succesfull");
            System.out.println("Balance: " + a);
        }
        public void withdraw(int a){
            if (a > amount){
                System.out.println("Insufficent Balance");
            }
            else{
                System.out.println("Withdraw Successfull");
                amount -= a;
                System.out.println("Balance: " + a);
            }
        }
    }
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500) ;
    }
}
