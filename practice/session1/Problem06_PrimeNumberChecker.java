/*
 * Problem 6: Prime Number Checker
 * Checks divisors from 2 up to the square root of each input number.
 */
import java.util.Scanner;

public class Problem06_PrimeNumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            System.out.println(number + (isPrime(number) ? " is prime" : " is not prime"));
        }
    }

    private static boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        for (long divisor = 2; divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
