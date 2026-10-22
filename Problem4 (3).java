import java.util.Locale;
import java.util.Scanner;

abstract class ElectricityConnection {
    protected final double units;

    protected ElectricityConnection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    HomeConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units <= 100 ? units * 5.0 : 100 * 5.0 + (units - 100) * 7.0;
    }
}

class ShopConnection extends ElectricityConnection {
    ShopConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0 + 100.0;
    }
}

class FactoryConnection extends ElectricityConnection {
    FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] types = new String[count];
        ElectricityConnection[] connections = new ElectricityConnection[count];

        for (int i = 0; i < count; i++) {
            String type = scanner.next().toUpperCase(Locale.ROOT);
            double units = scanner.nextDouble();
            types[i] = type;
            switch (type) {
                case "HOME":
                    connections[i] = new HomeConnection(units);
                    break;
                case "SHOP":
                    connections[i] = new ShopConnection(units);
                    break;
                case "FACTORY":
                    connections[i] = new FactoryConnection(units);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown connection type: " + type);
            }
        }

        double total = 0.0;
        for (int i = 0; i < connections.length; i++) {
            double bill = connections[i].calculateBill();
            System.out.printf(Locale.US, "%s: %.2f%n", types[i], bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
        scanner.close();
    }
}
