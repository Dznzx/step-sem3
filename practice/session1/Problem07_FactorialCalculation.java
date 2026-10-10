/*
 * Problem 7: Factorial Calculation
 * Computes n! with a loop; 0! is 1. BigInteger avoids overflow for larger inputs.
 */
import java.math.BigInteger;
import java.util.Scanner;

public class Problem07_FactorialCalculation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            System.out.println(factorial(scanner.nextInt()));
        }
    }

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
