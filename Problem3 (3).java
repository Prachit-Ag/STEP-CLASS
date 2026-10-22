import java.util.*;

abstract class LibraryItem {
    private final String title;
    protected final int daysLate;

    protected LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        LibraryItem[] items = new LibraryItem[count];

        for (int i = 0; i < count; i++) {
            String type = scanner.next().toUpperCase(Locale.ROOT);
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            switch (type) {
                case "BOOK":
                    items[i] = new BookItem(title, daysLate);
                    break;
                case "DVD":
                    items[i] = new DVDItem(title, daysLate);
                    break;
                case "MAGAZINE":
                    items[i] = new MagazineItem(title, daysLate);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item type: " + type);
            }
        }

        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf(Locale.US, "%s: %.2f%n", item.getTitle(), fine);
            totalFines += fine;
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", totalFines);
        scanner.close();
    }
}
