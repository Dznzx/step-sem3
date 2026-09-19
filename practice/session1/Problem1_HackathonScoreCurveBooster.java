/*
 * Category C - Problem 1: Hackathon Score Curve Booster
 * Boosts every score in place (no new array, no return value) and prints
 * the result using Arrays.toString().
 */
import java.util.Arrays;

public class Problem1_HackathonScoreCurveBooster {

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores));
    }

    private static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }
}
