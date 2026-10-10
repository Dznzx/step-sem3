/*
 * Problem 4: In-Place Array Reversal
 * Reverses the array with two pointers, swapping toward the center, without a second array.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Problem04_InPlaceArrayReversal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = parseList(scanner.nextLine());
        reverseInPlace(tokens);
        System.out.println(Arrays.toString(tokens));
    }

    private static void reverseInPlace(int[] values) {
        int left = 0;
        int right = values.length - 1;
        while (left < right) {
            int temp = values[left];
            values[left] = values[right];
            values[right] = temp;
            left++;
            right--;
        }
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
