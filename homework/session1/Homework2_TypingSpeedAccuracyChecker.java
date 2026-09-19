/*
 * Week 1 Assignment - Problem 2: Typing Speed Test Accuracy Checker
 * Compares a typed passage to the original character by character,
 * reporting the match count, accuracy percentage, and first mismatch.
 */
public class Homework2_TypingSpeedAccuracyChecker {

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }

    private static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1;
            }
        }

        double accuracy = (matched * 100.0) / original.length();
        String mismatchInfo;
        if (firstMismatchPosition == -1) {
            mismatchInfo = "No Mismatches";
        } else {
            char originalChar = original.charAt(firstMismatchPosition - 1);
            char typedChar = typed.charAt(firstMismatchPosition - 1);
            mismatchInfo = "First Mismatch at position " + firstMismatchPosition
                    + " ('" + originalChar + "' vs '" + typedChar + "')";
        }

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | %s%n",
                matched, original.length(), accuracy, mismatchInfo);
    }
}
