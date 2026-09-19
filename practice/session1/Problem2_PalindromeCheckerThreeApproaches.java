/*
 * Day 1 - Problem 2: Palindrome Checker (3 Approaches)
 * Verifies palindrome detection using iteration, recursion, and array
 * reversal, then confirms all three agree on the same input.
 */
public class Problem2_PalindromeCheckerThreeApproaches {

    public static void main(String[] args) {
        checkAllApproaches("madam");
        checkAllApproaches("hello");
    }

    private static void checkAllApproaches(String text) {
        String iterative = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String recursive = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String arrayReversal = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";

        System.out.println("Iterative: " + iterative + " | Recursive: " + recursive
                + " | Array Reversal: " + arrayReversal);
    }

    private static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    private static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return new String(original).equals(new String(reversed));
    }
}
