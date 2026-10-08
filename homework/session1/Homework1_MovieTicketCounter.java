/*
 * Assignment Problem 1: Movie Ticket Counter
 * Abstract Ticket holds the count and the single convenience fee; seat types only supply their price.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework1_MovieTicketCounter {

    abstract static class Ticket {
        private static final double CONVENIENCE_FEE = 20;
        protected final int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract String seatType();

        abstract double pricePerTicket();

        final double amount() {
            return count * (pricePerTicket() + CONVENIENCE_FEE);
        }
    }

    static class RegularTicket extends Ticket {
        RegularTicket(int c) { super(c); }
        String seatType() { return "REGULAR"; }
        double pricePerTicket() { return 150; }
    }

    static class PremiumTicket extends Ticket {
        PremiumTicket(int c) { super(c); }
        String seatType() { return "PREMIUM"; }
        double pricePerTicket() { return 250; }
    }

    static class ReclinerTicket extends Ticket {
        ReclinerTicket(int c) { super(c); }
        String seatType() { return "RECLINER"; }
        double pricePerTicket() { return 400; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Ticket> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            switch (seat) {
                case "REGULAR": bookings.add(new RegularTicket(count)); break;
                case "PREMIUM": bookings.add(new PremiumTicket(count)); break;
                case "RECLINER": bookings.add(new ReclinerTicket(count)); break;
                default: throw new IllegalArgumentException("Unknown seat type: " + seat);
            }
        }
        double total = 0;
        for (Ticket booking : bookings) {
            double amount = booking.amount();
            total += amount;
            System.out.printf("%s: %.2f%n", booking.seatType(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
