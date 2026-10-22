import java.util.*;
abstract class Plot {
    private final String owner;
    protected Plot(String owner) {
        this.owner = owner;
    }
    public String getOwner() {
        return owner;
    }
    public abstract String getShape();
    public abstract double getArea();
}
class Circle extends Plot {
    private final double radius;
    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
    public String getShape() {
        return "CIRCLE";
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
class Rectangle extends Plot {
    private final double length;
    private final double width;
    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
    public String getShape() {
        return "RECTANGLE";
    }
    public double getArea() {
        return length * width;
    }
}
class Triangle extends Plot {
    private final double base;
    private final double height;
    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
    public String getShape() {
        return "TRIANGLE";
    }
    public double getArea() {
        return 0.5 * base * height;
    }
}
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String shape = sc.next().toUpperCase(Locale.ROOT);
            String owner = sc.next();
            switch (shape) {
                case "CIRCLE":
                    plots.add(new Circle(owner, sc.nextDouble()));
                    break;
                case "RECTANGLE":
                    plots.add(new Rectangle(owner, sc.nextDouble(), sc.nextDouble()));
                    break;
                case "TRIANGLE":
                    plots.add(new Triangle(owner, sc.nextDouble(), sc.nextDouble()));
                    break;
                default:
                    System.out.println("Invalid Shape Entered");
            }
        }
        double totalArea = 0.0;
        for (Plot plot : plots) {
            double area = plot.getArea();
            System.out.printf("%s (%s): %.2f%n", plot.getOwner(), plot.getShape(), area);
            totalArea += area;
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}