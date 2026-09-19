/*
 * Day 1 - Problem 4: First Non-Repeating Character
 * Counts character frequencies with a fixed-size array (ASCII range) and
 * scans left to right for the first character occurring exactly once.
 */
public class Problem4_FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        printFirstNonRepeatingChar("swiss");
        printFirstNonRepeatingChar("aabbcc");
    }

    private static void printFirstNonRepeatingChar(String text) {
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }

    private static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }
}
