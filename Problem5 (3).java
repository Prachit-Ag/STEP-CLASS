
import java.util.*;

abstract class Appliance {
    static final double COST_PER_UNIT = 8.0;
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    boolean supportsSaver() {
        return false;
    }

    double getUnits(boolean saver) {
        double units = getPower() * hours / 1000;

        if (saver && supportsSaver()) {
            units *= 0.75;
        }

        return units;
    }

    double getCost(boolean saver) {
        return getUnits(saver) * COST_PER_UNIT;
    }
}

interface SaverMode {
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    boolean supportsSaver() {
        return true;
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");

            if (saver) {
                sc.next();
            }

            Appliance appliance = null;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
            }

            if (appliance != null) {
                if (saver && !(appliance instanceof SaverMode)) {
                    System.out.println(type + ": saver mode not supported");
                } else {
                    double units = appliance.getUnits(saver);
                    double cost = appliance.getCost(saver);

                    System.out.printf(
                        "%s: Units=%.2f Cost=%.2f%n",
                        type, units, cost
                    );

                    total += cost;
                }
            }
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
