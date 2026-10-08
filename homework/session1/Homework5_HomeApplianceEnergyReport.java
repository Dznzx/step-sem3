/*
 * Assignment Problem 5: Home Appliance Energy Report
 * Every appliance computes units from its power rating; saver mode is a SaverMode interface
 * that only the AC and washer implement.
 */
import java.util.Scanner;

public class Homework5_HomeApplianceEnergyReport {

    interface SaverMode {
        double SAVER_REDUCTION = 0.25;

        default double applySaver(double units) {
            return units * (1 - SAVER_REDUCTION);
        }
    }

    abstract static class Appliance {
        private static final double COST_PER_UNIT = 8;

        abstract String name();

        abstract double powerWatts();

        final double units(double hours) {
            return powerWatts() * hours / 1000;
        }

        static double cost(double units) {
            return units * COST_PER_UNIT;
        }
    }

    static class Fridge extends Appliance {
        String name() { return "FRIDGE"; }
        double powerWatts() { return 150; }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        String name() { return "AC"; }
        double powerWatts() { return 1500; }
    }

    static class Television extends Appliance {
        String name() { return "TV"; }
        double powerWatts() { return 100; }
    }

    static class WashingMachine extends Appliance implements SaverMode {
        String name() { return "WASHER"; }
        double powerWatts() { return 500; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        double totalCost = 0;
        int processed = 0;
        while (processed < n) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            processed++;
            String[] parts = line.split("\\s+");
            Appliance appliance = createAppliance(parts[0]);
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && parts[2].equals("SAVER");

            double units = appliance.units(hours);
            if (saverRequested) {
                if (!(appliance instanceof SaverMode saver)) {
                    System.out.println(appliance.name() + ": saver mode not supported");
                    continue;
                }
                units = saver.applySaver(units);
            }
            double cost = Appliance.cost(units);
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.name(), units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }

    private static Appliance createAppliance(String type) {
        switch (type) {
            case "FRIDGE": return new Fridge();
            case "AC": return new AirConditioner();
            case "TV": return new Television();
            case "WASHER": return new WashingMachine();
            default: throw new IllegalArgumentException("Unknown appliance: " + type);
        }
    }
}
