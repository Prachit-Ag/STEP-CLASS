import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class LibraryItem {
    protected String title;
    public LibraryItem(String title) { this.title = title; }
    public abstract LocalDate calculateDueDate(LocalDate currentDate);
    public String getTitle() { return title; }
}

class Book extends LibraryItem {
    public Book(String title) { super(title); }
    public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(14); }
}

class DVD extends LibraryItem {
    public DVD(String title) { super(title); }
    public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(7); }
}

class Magazine extends LibraryItem {
    public Magazine(String title) { super(title); }
    public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(3); }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        Pattern pattern = Pattern.compile("(\\S+)\\s+\"([^\"]+)\"");
        
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String type = matcher.group(1);
                String title = matcher.group(2);
                LibraryItem item = switch (type) {
                    case "BOOK" -> new Book(title);
                    case "DVD" -> new DVD(title);
                    case "MAGAZINE" -> new Magazine(title);
                    default -> throw new IllegalArgumentException("Unknown type");
                };
                System.out.println(item.getTitle() + ": " + item.calculateDueDate(currentDate));
            }
        }
    }
}