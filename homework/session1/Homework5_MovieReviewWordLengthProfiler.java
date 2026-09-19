/*
 * Week 1 Assignment - Problem 5: Movie Review Word Length Profiler
 * Splits a review into words and classifies each as Short (1-4), Medium
 * (5-8), or Long (9+) letters, then prints the category counts.
 */
public class Homework5_MovieReviewWordLengthProfiler {

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }

    private static void classifyWordLengths(String review) {
        String[] words = review.split(" ");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int length = word.length();
            if (length <= 4) {
                shortCount++;
            } else if (length <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }
}
