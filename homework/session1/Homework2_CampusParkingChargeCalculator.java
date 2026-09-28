/*
 * Assignment Problem 2: The Campus Parking Charge Calculator
 * Each vehicle type overrides charge(); the parking system processes all vehicles uniformly.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework2_CampusParkingChargeCalculator {

    abstract static class ParkedVehicle {
        protected final int hours;

        ParkedVehicle(int hours) {
            this.hours = hours;
        }

        abstract String type();

        abstract double charge();
    }

    static class Bike extends ParkedVehicle {
        Bike(int h) { super(h); }
        String type() { return "BIKE"; }
        double charge() { return 10.0 * hours; }
    }

    static class Car extends ParkedVehicle {
        Car(int h) { super(h); }
        String type() { return "CAR"; }
        double charge() { return 30.0 + 20.0 * (hours - 1); }
    }

    static class Truck extends ParkedVehicle {
        Truck(int h) { super(h); }
        String type() { return "TRUCK"; }
        double charge() { return Math.max(100.0, 50.0 * hours); }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<ParkedVehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            switch (type) {
                case "BIKE": vehicles.add(new Bike(hours)); break;
                case "CAR": vehicles.add(new Car(hours)); break;
                case "TRUCK": vehicles.add(new Truck(hours)); break;
                default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
            }
        }
        double total = 0;
        for (ParkedVehicle vehicle : vehicles) {
            double charge = vehicle.charge();
            total += charge;
            System.out.printf("%s: %.2f%n", vehicle.type(), charge);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
