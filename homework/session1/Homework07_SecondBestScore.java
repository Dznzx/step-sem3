/*
 * Assignment Problem 7: Second-Best Score
 * One pass with two variables (highest, second); a score equal to the current
 * highest is skipped so the answer is the second-highest DISTINCT score.
 *
 * Time: O(n), Extra space: O(1).
 * Sorting first would cost O(n log n) time (plus a copy if the original must stay intact).
 */
public class Homework07_SecondBestScore {

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[] {45, 78, 92, 78, 60}));
        System.out.println(secondHighest(new int[] {50, 50, 50}));
    }

    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second;
    }
}
