import java.util.Scanner;

abstract class Transport {
    protected double distance;
    public Transport(double distance) { this.distance = distance; }
    public abstract double calculateFare();
    public abstract String getType();
}

class Bus extends Transport {
    public Bus(double distance) { super(distance); }
    public double calculateFare() { return Math.min(10.00, 2.00 + (0.10 * distance)); }
    public String getType() { return "BUS"; }
}

class Train extends Transport {
    public Train(double distance) { super(distance); }
    public double calculateFare() { return 3.00 + (0.15 * distance); }
    public String getType() { return "TRAIN"; }
}

class Metro extends Transport {
    private double peakFactor;
    public Metro(double distance, double peakFactor) {
        super(distance);
        this.peakFactor = peakFactor;
    }
    public double calculateFare() { return (1.50 + (0.20 * distance)) * peakFactor; }
    public String getType() { return "METRO"; }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalFare = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            Transport transport = switch (type) {
                case "BUS" -> new Bus(distance);
                case "TRAIN" -> new Train(distance);
                case "METRO" -> new Metro(distance, scanner.nextDouble());
                default -> throw new IllegalArgumentException("Unknown type");
            };
            
            double fare = transport.calculateFare();
            totalFare += fare;
            System.out.printf("%s: %.2f%n", transport.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", totalFare);
    }
}