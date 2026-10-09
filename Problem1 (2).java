import java.util.*;

public class Problem1 {
    interface BillRule { double calculate(double amount); }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, BillRule> rules = Map.of(
            "STUDENT", amount -> amount * 0.90,
            "STAFF", amount -> amount * 0.95,
            "GUEST", amount -> amount + 10.0
        );
        int n = in.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT);
            double amount = in.nextDouble();
            double result = rules.get(type).calculate(amount);
            System.out.printf(Locale.US, "%s: %.2f%n", type, result);
            total += result;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
