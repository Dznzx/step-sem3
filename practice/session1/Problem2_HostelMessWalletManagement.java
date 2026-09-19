/*
 * Category C - Problem M2: Hostel Mess Wallet Management
 * Encapsulated wallet balance: no public setter, top-up/deduct validated
 * so the balance can never go negative.
 */
public class Problem2_HostelMessWalletManagement {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());

        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}

class MessWallet {
    private double balance;

    MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: negative opening balance, starting at 0 instead.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
            return;
        }
        balance += amount;
    }

    void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        balance -= amount;
    }

    double getBalance() {
        return balance;
    }
}
