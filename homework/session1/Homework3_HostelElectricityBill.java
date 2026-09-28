/*
 * Assignment Problem 3: The Hostel Electricity Bill
 * Each room type overrides bill(); a shared room stores its own occupant count so the loop stays uniform.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework3_HostelElectricityBill {

    abstract static class Room {
        protected final int units;

        Room(int units) {
            this.units = units;
        }

        abstract String type();

        abstract double bill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int u) { super(u); }
        String type() { return "SINGLE"; }
        double bill() { return 8.0 * units; }
    }

    static class SharedRoom extends Room {
        private final int occupants;

        SharedRoom(int u, int occupants) {
            super(u);
            this.occupants = occupants;
        }

        String type() { return "SHARED"; }
        double bill() { return 6.0 * units / occupants; }
    }

    static class AcRoom extends Room {
        AcRoom(int u) { super(u); }
        String type() { return "AC"; }
        double bill() { return 10.0 * units + 200; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            switch (type) {
                case "SINGLE": rooms.add(new SingleRoom(units)); break;
                case "SHARED": rooms.add(new SharedRoom(units, scanner.nextInt())); break;
                case "AC": rooms.add(new AcRoom(units)); break;
                default: throw new IllegalArgumentException("Unknown room type: " + type);
            }
        }
        double total = 0;
        for (Room room : rooms) {
            double bill = room.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", room.type(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
