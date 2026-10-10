/*
 * Problem 2: Word Reverser and Palindrome Checker
 * Reverses each input word with StringBuilder and reports whether it is a palindrome.
 */
import java.util.Scanner;

public class Problem02_WordReverserAndPalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.next();
            String reversed = reverseWord(word);
            String verdict = word.equals(reversed) ? "palindrome" : "not a palindrome";
            System.out.println(reversed + " - " + verdict);
        }
    }

    private static String reverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
