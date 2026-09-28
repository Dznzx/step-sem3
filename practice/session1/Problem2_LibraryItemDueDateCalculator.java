/*
 * Problem 2: Library Item Due Date Calculator
 * Each item type overrides its loan period; due dates are computed uniformly from 2023-10-26.
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2_LibraryItemDueDateCalculator {

    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    abstract static class LibraryItem {
        protected final String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int loanPeriodDays();

        LocalDate dueDate(LocalDate from) {
            return from.plusDays(loanPeriodDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        int loanPeriodDays() { return 14; }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) { super(title); }
        int loanPeriodDays() { return 7; }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        int loanPeriodDays() { return 3; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        while (items.size() < count) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim().replace("\"", "");
            items.add(createItem(type, title));
        }
        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.dueDate(CURRENT_DATE));
        }
    }

    private static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK": return new Book(title);
            case "DVD": return new Dvd(title);
            case "MAGAZINE": return new Magazine(title);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }
}
