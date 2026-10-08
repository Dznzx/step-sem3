/*
 * Problem 4: Electricity Connection Billing
 * Abstract Connection holds units; each connection type implements bill().
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem4_ElectricityConnectionBilling {

    abstract static class Connection {
        protected final double units;

        Connection(double units) {
            this.units = units;
        }

        abstract String type();

        abstract double bill();
    }

    static class HomeConnection extends Connection {
        HomeConnection(double u) { super(u); }
        String type() { return "HOME"; }
        double bill() { return 5.0 * Math.min(units, 100) + 7.0 * Math.max(0, units - 100); }
    }

    static class ShopConnection extends Connection {
        ShopConnection(double u) { super(u); }
        String type() { return "SHOP"; }
        double bill() { return 8.0 * units + 100; }
    }

    static class FactoryConnection extends Connection {
        FactoryConnection(double u) { super(u); }
        String type() { return "FACTORY"; }
        double bill() { return Math.max(1000, 6.0 * units); }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            switch (type) {
                case "HOME": connections.add(new HomeConnection(units)); break;
                case "SHOP": connections.add(new ShopConnection(units)); break;
                case "FACTORY": connections.add(new FactoryConnection(units)); break;
                default: throw new IllegalArgumentException("Unknown connection type: " + type);
            }
        }
        double total = 0;
        for (Connection connection : connections) {
            double bill = connection.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", connection.type(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
