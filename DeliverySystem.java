import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;
    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }
    public abstract double calculateFee();
    public abstract String getType();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) { super(weight, distance); }
    public double calculateFee() { return 5.00 + (0.50 * weight) + (0.10 * distance); }
    public String getType() { return "STANDARD"; }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) { super(weight, distance); }
    public double calculateFee() { return 15.00 + (1.00 * weight) + (0.20 * distance); }
    public String getType() { return "EXPRESS"; }
}

class InternationalDelivery extends Delivery {
    private double customsFee;
    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }
    public double calculateFee() { return 25.00 + (2.00 * weight) + (0.50 * distance) + customsFee; }
    public String getType() { return "INTERNATIONAL"; }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalFee = 0.0;
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            Delivery delivery = switch (type) {
                case "STANDARD" -> new StandardDelivery(weight, distance);
                case "EXPRESS" -> new ExpressDelivery(weight, distance);
                case "INTERNATIONAL" -> new InternationalDelivery(weight, distance, scanner.nextDouble());
                default -> throw new IllegalArgumentException("Unknown type");
            };
            
            double fee = delivery.calculateFee();
            totalFee += fee;
            System.out.printf("%s: %.2f%n", delivery.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", totalFee);
    }
}