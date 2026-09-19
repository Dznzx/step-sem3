/*
 * Category C - Problem 3: Top-3 Podium Finder
 * Tracks the top three scores in a single left-to-right pass, without
 * sorting the array, returning them in descending order.
 */
import java.util.Arrays;

public class Problem3_TopThreePodiumFinder {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTopThreeScores(new int[] {45, 82, 79, 90, 33, 90, 61})));
    }

    private static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[] {first, second, third};
    }
}
