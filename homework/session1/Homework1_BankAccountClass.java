/*
 * Homework 1: Bank Account Class
 *
 * Best programming practices demonstrated:
 *  - Fixed value (bank name), user input, and result variables separated.
 *  - Deposit/withdraw logic factored into clearly named instance methods.
 *  - Static field/method shared across all accounts.
 */
import java.util.Scanner;

public class Homework1_BankAccountClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String holderName = scanner.nextLine(); // user input

        BankAccount account = new BankAccount(holderName);
        account.deposit(500.0);
        account.withdraw(150.0);
        account.printStatement();

        System.out.println("Total accounts opened at " + BankAccount.getBankName() + ": " + BankAccount.getTotalAccounts());
    }
}

class BankAccount {
    private static final String BANK_NAME = "Java National Bank"; // fixed value
    private static int totalAccounts = 0;

    private final String holderName;
    private double balance;

    BankAccount(String holderName) {
        this.holderName = holderName;
        this.balance = 0.0;
        totalAccounts++;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance for " + holderName);
            return;
        }
        balance -= amount;
    }

    void printStatement() {
        System.out.println(holderName + "'s balance: " + balance); // result
    }

    static String getBankName() {
        return BANK_NAME;
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }
}
