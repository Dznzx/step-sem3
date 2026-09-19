/*
 * Category C Assignment - Problem 4: Match Day Grid Analyzer
 * Classifies each (possibly jagged) match row using a single reusable
 * rowAverage() helper called once per match.
 */
public class Homework4_MatchDayGridAnalyzer {

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));
    }

    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    private static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);
            String zone = (average >= threshold) ? "Power Surge" : "Normal";
            if (i > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ").append(zone);
        }
        return result.toString();
    }
}
