/*
 * Category C - Problem 1: The Piggy Bank
 * Savings is private and can only change through deposit/withdraw; a
 * withdrawal larger than the balance is rejected outright. ID is final.
 */
public class Problem1_ThePiggyBank {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println(pb.getSavings());
        pb.withdraw(30);
        System.out.println(pb.getSavings());
        pb.withdraw(500);
        System.out.println(pb.getSavings());
    }
}

class PiggyBank {
    private final String id;
    private double savings;

    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(double amount) {
        savings += amount;
    }

    void withdraw(double amount) {
        if (amount > savings) {
            return;
        }
        savings -= amount;
    }

    double getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }
}
