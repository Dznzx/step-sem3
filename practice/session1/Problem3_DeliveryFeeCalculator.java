/*
 * Problem 3: Delivery Fee Calculator
 * Each delivery type overrides calculateFee() using the business rules from the problem statement.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem3_DeliveryFeeCalculator {

    abstract static class Delivery {
        protected final double weight;
        protected final double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract String type();

        abstract double calculateFee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double w, double d) { super(w, d); }
        String type() { return "STANDARD"; }
        double calculateFee() { return 5 + 0.50 * weight + 0.10 * distance; }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double w, double d) { super(w, d); }
        String type() { return "EXPRESS"; }
        double calculateFee() { return 15 + 1.00 * weight + 0.20 * distance; }
    }

    static class InternationalDelivery extends Delivery {
        private final double customsFee;

        InternationalDelivery(double w, double d, double customsFee) {
            super(w, d);
            this.customsFee = customsFee;
        }

        String type() { return "INTERNATIONAL"; }
        double calculateFee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            deliveries.add(createDelivery(type, weight, distance, scanner));
        }
        double total = 0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", delivery.type(), fee);
        }
        System.out.printf("Total: %.2f%n", total);
    }

    private static Delivery createDelivery(String type, double weight, double distance, Scanner scanner) {
        switch (type) {
            case "STANDARD": return new StandardDelivery(weight, distance);
            case "EXPRESS": return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL": return new InternationalDelivery(weight, distance, scanner.nextDouble());
            default: throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }
}
