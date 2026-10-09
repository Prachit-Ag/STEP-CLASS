import java.util.*;

public class Problem3 {
    interface BillRule { double calculate(int units, int occupants); }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, BillRule> rules = Map.of(
            "SINGLE", (units, occupants) -> units * 8.0,
            "SHARED", (units, occupants) -> units * 6.0 / occupants,
            "AC", (units, occupants) -> units * 10.0 + 200.0
        );
        int n = in.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT);
            int units = in.nextInt();
            int occupants = type.equals("SHARED") ? in.nextInt() : 1;
            double bill = rules.get(type).calculate(units, occupants);
            System.out.printf(Locale.US, "%s: %.2f%n", type, bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
