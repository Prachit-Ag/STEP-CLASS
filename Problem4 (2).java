import java.util.*;

public class Problem4{
    interface BonusRule { double calculate(double salary); }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, BonusRule> rules = Map.of(
            "FULLTIME", salary -> salary * 0.10,
            "PARTTIME", salary -> salary * 0.05,
            "INTERN", salary -> 2000.0
        );
        int n = in.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT);
            String name = in.next();
            double salary = in.nextDouble();
            double bonus = rules.get(type).calculate(salary);
            System.out.printf(Locale.US, "%s: %.2f%n", name, bonus);
            total += bonus;
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}
