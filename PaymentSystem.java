import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Payment {
    protected double amount;
    public Payment(double amount) { this.amount = amount; }
    public abstract double calculateAdjustedAmount();
    public abstract String getType();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    public double calculateAdjustedAmount() { return amount * 1.02; }
    public String getType() { return "CARD"; }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }
    public double calculateAdjustedAmount() { return amount * 1.01; }
    public String getType() { return "WALLET"; }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }
    public double calculateAdjustedAmount() { return amount; }
    public String getType() { return "BANKTRANSFER"; }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double grandTotal = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            Payment payment = switch (type) {
                case "CARD" -> new CardPayment(amount);
                case "WALLET" -> new WalletPayment(amount);
                case "BANKTRANSFER" -> new BankTransferPayment(amount);
                default -> throw new IllegalArgumentException("Unknown type");
            };
            
            double adjusted = payment.calculateAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf("%s: %.2f%n", payment.getType(), adjusted);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}