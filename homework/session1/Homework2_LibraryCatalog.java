/*
 * Homework 2: Library Book Catalog
 * Model a small library catalog with an array of Book objects, a static
 * counter for total books, and a method to find available books.
 */
public class Homework2_LibraryCatalog {
    public static void main(String[] args) {
        LibraryBook[] catalog = {
            new LibraryBook("The Hobbit", true),
            new LibraryBook("Dune", false),
            new LibraryBook("1984", true)
        };

        printAvailableBooks(catalog);
        System.out.println("Total books catalogued: " + LibraryBook.getTotalBooks());
    }

    private static void printAvailableBooks(LibraryBook[] catalog) {
        for (LibraryBook book : catalog) {
            if (book.isAvailable()) {
                System.out.println("Available: " + book.getTitle());
            }
        }
    }
}

class LibraryBook {
    private static int totalBooks = 0;

    private final String title;
    private final boolean available;

    LibraryBook(String title, boolean available) {
        this.title = title;
        this.available = available;
        totalBooks++;
    }

    String getTitle() {
        return title;
    }

    boolean isAvailable() {
        return available;
    }

    static int getTotalBooks() {
        return totalBooks;
    }
}
