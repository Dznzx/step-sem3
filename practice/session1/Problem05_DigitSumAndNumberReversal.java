/*
 * Problem 5: Digit Sum and Number Reversal
 * Extracts digits with % 10 and / 10 to compute the digit sum and the reversed number.
 */
import java.util.Scanner;

public class Problem05_DigitSumAndNumberReversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        System.out.println("Sum of digits: " + digitSum(number));
        System.out.println("Reverse: " + reverseNumber(number));
    }

    private static long digitSum(long number) {
        long sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static long reverseNumber(long number) {
        long reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }
}
