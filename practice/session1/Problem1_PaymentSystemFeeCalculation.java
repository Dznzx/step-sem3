/*
 * Problem 1: Payment System Fee Calculation
 * Each payment type overrides finalAmount(); the processing loop treats all payments uniformly.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1_PaymentSystemFeeCalculation {

    abstract static class Payment {
        protected final double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract String type();

        abstract double finalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) { super(amount); }
        String type() { return "CARD"; }
        double finalAmount() { return amount * 1.02; }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) { super(amount); }
        String type() { return "WALLET"; }
        double finalAmount() { return amount * 1.01; }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) { super(amount); }
        String type() { return "BANKTRANSFER"; }
        double finalAmount() { return amount; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            payments.add(createPayment(scanner.next(), scanner.nextDouble()));
        }
        processPayments(payments);
    }

    private static Payment createPayment(String type, double amount) {
        switch (type) {
            case "CARD": return new CardPayment(amount);
            case "WALLET": return new WalletPayment(amount);
            case "BANKTRANSFER": return new BankTransferPayment(amount);
            default: throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    private static void processPayments(List<Payment> payments) {
        double total = 0;
        for (Payment payment : payments) {
            double adjusted = payment.finalAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", payment.type(), adjusted);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
