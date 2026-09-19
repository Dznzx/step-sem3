/*
 * Category C - Problem 4: Hackathon Seating Grid Optimizer
 * Classifies each (possibly jagged) row using a single reusable
 * rowAverage() helper called once per row.
 */
public class Problem4_HackathonSeatingGridOptimizer {

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
    }

    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    private static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);
            String zone = (average < threshold) ? "Quiet Zone" : "Buzzing Zone";
            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ").append(zone);
        }
        return result.toString();
    }
}
