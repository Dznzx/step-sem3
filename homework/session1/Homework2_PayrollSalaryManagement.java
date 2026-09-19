/*
 * Category C Assignment - Problem M2: Payroll Salary Management
 * Encapsulated salary and bonus: only credit/deduct methods can change
 * state, both validated, with a read-only net salary accessor.
 */
public class Homework2_PayrollSalaryManagement {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);

        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            System.out.println("Warning: negative basic salary, starting at 0 instead.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = openingBasicSalary;
        }
    }

    void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be positive");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax deduction rejected: percent must be between 0 and 100");
            return;
        }
        basicSalary -= basicSalary * (percent / 100.0);
        System.out.println("Tax deducted: " + (int) percent + "%");
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }
}
