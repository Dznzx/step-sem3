/*
 * Week 1 Assignment - Problem 3: Traffic Signal Streak Analyzer
 * Scans a signal log to find the longest streak of consecutive identical
 * characters, tracking a running maximum as it goes.
 */
public class Homework3_TrafficSignalStreakAnalyzer {

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }

    private static void findLongestStreak(String signalLog) {
        char longestStreakColor = signalLog.charAt(0);
        int longestStreakLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreakLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char current = signalLog.charAt(i);
            if (current == currentColor) {
                currentStreakLength++;
            } else {
                currentColor = current;
                currentStreakLength = 1;
            }

            if (currentStreakLength > longestStreakLength) {
                longestStreakLength = currentStreakLength;
                longestStreakColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestStreakColor + "' repeated " + longestStreakLength + " times");
    }
}
