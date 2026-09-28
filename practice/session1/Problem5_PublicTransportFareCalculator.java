/*
 * Problem 5: Public Transport Fare Calculator
 * Each transport type overrides calculateFare(); METRO carries its own peak-hour factor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5_PublicTransportFareCalculator {

    abstract static class Journey {
        protected final double distance;

        Journey(double distance) {
            this.distance = distance;
        }

        abstract String type();

        abstract double calculateFare();
    }

    static class BusJourney extends Journey {
        BusJourney(double d) { super(d); }
        String type() { return "BUS"; }
        double calculateFare() { return Math.min(10, 2 + 0.10 * distance); }
    }

    static class TrainJourney extends Journey {
        TrainJourney(double d) { super(d); }
        String type() { return "TRAIN"; }
        double calculateFare() { return 3 + 0.15 * distance; }
    }

    static class MetroJourney extends Journey {
        private final double peakHourFactor;

        MetroJourney(double d, double peakHourFactor) {
            super(d);
            this.peakHourFactor = peakHourFactor;
        }

        String type() { return "METRO"; }
        double calculateFare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            switch (type) {
                case "BUS": journeys.add(new BusJourney(distance)); break;
                case "TRAIN": journeys.add(new TrainJourney(distance)); break;
                case "METRO": journeys.add(new MetroJourney(distance, scanner.nextDouble())); break;
                default: throw new IllegalArgumentException("Unknown transport type: " + type);
            }
        }
        double total = 0;
        for (Journey journey : journeys) {
            double fare = journey.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", journey.type(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
