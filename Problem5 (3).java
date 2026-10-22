import java.util.Locale;
import java.util.Scanner;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    protected final double distanceKm;

    protected TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    protected abstract double calculateBaseFare();

    public abstract String getMode();

    public final double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 2.0;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 1.5;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2500.0 + distanceKm * 4.0;
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        TravelBooking[] bookings = new TravelBooking[count];

        for (int i = 0; i < count; i++) {
            String mode = scanner.next().toUpperCase(Locale.ROOT);
            double distanceKm = scanner.nextDouble();
            switch (mode) {
                case "BUS":
                    bookings[i] = new BusBooking(distanceKm);
                    break;
                case "TRAIN":
                    bookings[i] = new TrainBooking(distanceKm);
                    break;
                case "FLIGHT":
                    bookings[i] = new FlightBooking(distanceKm);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown travel mode: " + mode);
            }
        }

        for (TravelBooking booking : bookings) {
            System.out.printf(Locale.US, "%s: %.2f%n", booking.getMode(), booking.calculateTotal());
        }
        scanner.close();
    }
}
