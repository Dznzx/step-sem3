/*
 * Day 1 - Problem 3: BMI Calculator for a Team
 * Computes BMI for each team member from parallel height/weight arrays,
 * classifies each status, and prints a formatted wellness report table.
 */
public class Problem3_BmiCalculatorForTeam {

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.68, 1.82, 1.55};
        double[] weights = {70, 90, 55, 95, 48};

        printWellnessReport(heights, weights);
    }

    private static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%d | %.2f | %.1f | %.2f | %s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    private static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }
}
