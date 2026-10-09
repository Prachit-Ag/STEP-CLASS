import java.time.LocalDate;
import java.util.*;

public class Problem5 {
    interface RenewalRule { LocalDate calculate(LocalDate start); }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, RenewalRule> rules = Map.of(
            "BASIC", start -> start.plusDays(30),
            "STANDARD", start -> start.plusDays(90),
            "PREMIUM", start -> start.plusDays(365)
        );
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String type = in.next().toUpperCase(Locale.ROOT);
            String name = in.next();
            LocalDate start = LocalDate.parse(in.next());
            System.out.printf("%s: %s%n", name, rules.get(type).calculate(start));
        }
    }
}
