/*
 * Problem 1: Vowel and Consonant Counter
 * Counts vowels and consonants in a single alphabetic word (case-insensitive).
 */
import java.util.Scanner;

public class Problem01_VowelAndConsonantCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int vowels = countVowels(word);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + (word.length() - vowels));
    }

    private static int countVowels(String word) {
        int count = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                count++;
            }
        }
        return count;
    }
}
