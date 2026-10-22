
import java.util.*;

abstract class Cab {
    static final double MIN_FARE = 100;
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    boolean supportsNightService() {
        return false;
    }

    double getFare(String time) {
        double fare = Math.max(MIN_FARE, km * getRate());

        if (time.equals("NIGHT") && supportsNightService()) {
            fare *= 1.20;
        }

        return fare;
    }
}

interface NightService {
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    boolean supportsNightService() {
        return true;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    boolean supportsNightService() {
        return true;
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
            }

            if (cab != null) {
                if (time.equals("NIGHT")
                        && !(cab instanceof NightService)) {
                    System.out.println(type + ": night service not available");
                } else {
                    double fare = cab.getFare(time);
                    System.out.printf("%s: %.2f%n", type, fare);
                    total += fare;
                }
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
