/*
 * Problem 5: Travel Booking with a Common Fee
 * The booking fee lives once in the abstract base; subclasses only supply their base fare.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5_TravelBookingCommonFee {

    abstract static class Booking {
        private static final double BOOKING_FEE = 50;
        protected final double distanceKm;

        Booking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        abstract String mode();

        abstract double baseFare();

        final double total() {
            return baseFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        BusBooking(double d) { super(d); }
        String mode() { return "BUS"; }
        double baseFare() { return 2.0 * distanceKm; }
    }

    static class TrainBooking extends Booking {
        TrainBooking(double d) { super(d); }
        String mode() { return "TRAIN"; }
        double baseFare() { return 1.5 * distanceKm; }
    }

    static class FlightBooking extends Booking {
        FlightBooking(double d) { super(d); }
        String mode() { return "FLIGHT"; }
        double baseFare() { return 2500 + 4.0 * distanceKm; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            switch (mode) {
                case "BUS": bookings.add(new BusBooking(distance)); break;
                case "TRAIN": bookings.add(new TrainBooking(distance)); break;
                case "FLIGHT": bookings.add(new FlightBooking(distance)); break;
                default: throw new IllegalArgumentException("Unknown travel mode: " + mode);
            }
        }
        for (Booking booking : bookings) {
            System.out.printf("%s: %.2f%n", booking.mode(), booking.total());
        }
    }
}
