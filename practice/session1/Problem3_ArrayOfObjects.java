/*
 * Practice 3: Array of Objects
 * Create an array of Book objects and iterate over it to print details.
 */
public class Problem3_ArrayOfObjects {
    public static void main(String[] args) {
        Book[] books = createSampleBooks();
        printAllBooks(books);
    }

    private static Book[] createSampleBooks() {
        return new Book[] {
            new Book("Effective Java", "Joshua Bloch"),
            new Book("Clean Code", "Robert Martin"),
            new Book("Head First Java", "Kathy Sierra")
        };
    }

    private static void printAllBooks(Book[] books) {
        for (Book book : books) {
            book.printDetails();
        }
    }
}

class Book {
    private final String title;
    private final String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void printDetails() {
        System.out.println("\"" + title + "\" by " + author);
    }
}
