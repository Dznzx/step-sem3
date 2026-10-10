/*
 * Problem 3: Even and Odd Numbers in a List
 * Reads a list like [3, 8, 12] and counts even and odd values.
 */
import java.util.Scanner;

public class Problem03_EvenAndOddNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = parseList(scanner.nextLine());
        int even = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                even++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + (numbers.length - even));
    }

    private static int[] parseList(String line) {
        String inner = line.replace("[", "").replace("]", "").trim();
        if (inner.isEmpty()) {
            return new int[0];
        }
        String[] parts = inner.split("\\s*,\\s*");
        int[] values = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            values[i] = Integer.parseInt(parts[i].trim());
        }
        return values;
    }
}
