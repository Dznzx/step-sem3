/*
 * Category C Assignment - Problem 1: Fantasy Team Score Multiplier
 * Applies captain (2x) and vice-captain (1.5x) multipliers directly to
 * the caller's score array; only those two positions change.
 */
import java.util.Arrays;

public class Homework1_FantasyTeamScoreMultiplier {

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }

    private static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2;
        playerScores[viceCaptainIndex] *= 1.5;
    }
}
