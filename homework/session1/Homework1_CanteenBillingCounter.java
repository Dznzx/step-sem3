/*
 * Assignment Problem 1: The Canteen Billing Counter
 * Each customer type overrides finalAmount(); the counter processes all bills uniformly.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework1_CanteenBillingCounter {

    abstract static class Customer {
        protected final double billAmount;

        Customer(double billAmount) {
            this.billAmount = billAmount;
        }

        abstract String type();

        abstract double finalAmount();
    }

    static class StudentCustomer extends Customer {
        StudentCustomer(double a) { super(a); }
        String type() { return "STUDENT"; }
        double finalAmount() { return billAmount * 0.90; }
    }

    static class StaffCustomer extends Customer {
        StaffCustomer(double a) { super(a); }
        String type() { return "STAFF"; }
        double finalAmount() { return billAmount * 0.95; }
    }

    static class GuestCustomer extends Customer {
        GuestCustomer(double a) { super(a); }
        String type() { return "GUEST"; }
        double finalAmount() { return billAmount + 10; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            switch (type) {
                case "STUDENT": bills.add(new StudentCustomer(amount)); break;
                case "STAFF": bills.add(new StaffCustomer(amount)); break;
                case "GUEST": bills.add(new GuestCustomer(amount)); break;
                default: throw new IllegalArgumentException("Unknown customer type: " + type);
            }
        }
        double total = 0;
        for (Customer bill : bills) {
            double amount = bill.finalAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", bill.type(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
