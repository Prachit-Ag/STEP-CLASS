import java.util.*;

public class Problem2 {
    interface ChargeRule { double calculate(int hours); }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, ChargeRule> rules = Map.of(
            "BIKE", hours -> hours * 10.0,
            "CAR", hours -> 30.0 + (hours - 1) * 20.0,
            "TRUCK", hours -> Math.max(100.0, hours * 50.0)
        );
        int n = in.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT);
            int hours = in.nextInt();
            double charge = rules.get(type).calculate(hours);
            System.out.printf(Locale.US, "%s: %.2f%n", type, charge);
            total += charge;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
