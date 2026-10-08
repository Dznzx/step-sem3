/*
 * Problem 3: Library Late Fine Counter
 * Abstract LibraryItem holds title and days late; each item type implements fine().
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem3_LibraryLateFineCounter {

    abstract static class LibraryItem {
        protected final String title;
        protected final int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double fine();
    }

    static class Book extends LibraryItem {
        Book(String t, int d) { super(t, d); }
        double fine() { return 2.0 * daysLate; }
    }

    static class Dvd extends LibraryItem {
        Dvd(String t, int d) { super(t, d); }
        double fine() { return Math.min(50, 5.0 * daysLate); }
    }

    static class Magazine extends LibraryItem {
        Magazine(String t, int d) { super(t, d); }
        double fine() { return 1.0 * daysLate; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();
            switch (type) {
                case "BOOK": items.add(new Book(title, daysLate)); break;
                case "DVD": items.add(new Dvd(title, daysLate)); break;
                case "MAGAZINE": items.add(new Magazine(title, daysLate)); break;
                default: throw new IllegalArgumentException("Unknown item type: " + type);
            }
        }
        double total = 0;
        for (LibraryItem item : items) {
            double fine = item.fine();
            total += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}
