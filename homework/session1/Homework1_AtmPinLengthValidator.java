/*
 * Week 2 Assignment - Problem 1: ATM PIN Length Validator
 * The most basic check: length() plus a single if/else, no loop needed.
 */
public class Homework1_AtmPinLengthValidator {

    public static void main(String[] args) {
        checkPinLength("482");
        checkPinLength("4820");
    }

    private static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
}
