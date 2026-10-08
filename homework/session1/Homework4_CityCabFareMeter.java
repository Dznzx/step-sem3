/*
 * Assignment Problem 4: City Cab Fare Meter
 * The minimum-fare rule is shared in the abstract Cab; night service is a NightService interface
 * that only sedans and SUVs implement.
 */
import java.util.Scanner;

public class Homework4_CityCabFareMeter {

    interface NightService {
        double NIGHT_SURCHARGE = 0.20;

        default double applyNightSurcharge(double fare) {
            return fare * (1 + NIGHT_SURCHARGE);
        }
    }

    abstract static class Cab {
        private static final double MINIMUM_FARE = 100;

        abstract String type();

        abstract double ratePerKm();

        final double dayFare(double km) {
            return Math.max(MINIMUM_FARE, km * ratePerKm());
        }
    }

    static class MiniCab extends Cab {
        String type() { return "MINI"; }
        double ratePerKm() { return 10; }
    }

    static class SedanCab extends Cab implements NightService {
        String type() { return "SEDAN"; }
        double ratePerKm() { return 14; }
    }

    static class SuvCab extends Cab implements NightService {
        String type() { return "SUV"; }
        double ratePerKm() { return 18; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Cab cab = createCab(scanner.next());
            double km = scanner.nextDouble();
            boolean night = scanner.next().equals("NIGHT");

            double fare = cab.dayFare(km);
            if (night) {
                if (!(cab instanceof NightService nightCab)) {
                    System.out.println(cab.type() + ": night service not available");
                    continue;
                }
                fare = nightCab.applyNightSurcharge(fare);
            }
            total += fare;
            System.out.printf("%s: %.2f%n", cab.type(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }

    private static Cab createCab(String type) {
        switch (type) {
            case "MINI": return new MiniCab();
            case "SEDAN": return new SedanCab();
            case "SUV": return new SuvCab();
            default: throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }
}
