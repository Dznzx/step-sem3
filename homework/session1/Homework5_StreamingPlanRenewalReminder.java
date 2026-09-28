/*
 * Assignment Problem 5: The Streaming Plan Renewal Reminder
 * Each plan overrides validityDays(); renewal dates use LocalDate.plusDays (handles leap years and year change).
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework5_StreamingPlanRenewalReminder {

    abstract static class Subscription {
        protected final String name;
        protected final LocalDate startDate;

        Subscription(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class BasicPlan extends Subscription {
        BasicPlan(String n, LocalDate d) { super(n, d); }
        int validityDays() { return 30; }
    }

    static class StandardPlan extends Subscription {
        StandardPlan(String n, LocalDate d) { super(n, d); }
        int validityDays() { return 90; }
    }

    static class PremiumPlan extends Subscription {
        PremiumPlan(String n, LocalDate d) { super(n, d); }
        int validityDays() { return 365; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Subscription> subscriptions = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String plan = scanner.next();
            String name = scanner.next();
            LocalDate start = LocalDate.parse(scanner.next());
            switch (plan) {
                case "BASIC": subscriptions.add(new BasicPlan(name, start)); break;
                case "STANDARD": subscriptions.add(new StandardPlan(name, start)); break;
                case "PREMIUM": subscriptions.add(new PremiumPlan(name, start)); break;
                default: throw new IllegalArgumentException("Unknown plan type: " + plan);
            }
        }
        for (Subscription subscription : subscriptions) {
            System.out.println(subscription.name + ": " + subscription.renewalDate());
        }
    }
}
