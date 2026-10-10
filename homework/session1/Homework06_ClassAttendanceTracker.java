/*
 * Assignment Problem 6: Class Attendance Tracker
 * One pass: count present days, and keep a running streak that resets on every 0.
 *
 * Time: O(n), single pass for both answers. Extra space: O(1).
 */
public class Homework06_ClassAttendanceTracker {

    public static void main(String[] args) {
        printSummary(new int[] {1, 1, 0, 1, 1, 1, 0, 1});
        printSummary(new int[] {0, 0, 0});
    }

    private static void printSummary(int[] days) {
        int[] summary = attendanceSummary(days);
        System.out.println("Present: " + summary[0] + ", Longest streak: " + summary[1]);
    }

    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }
        return new int[] {present, longestStreak};
    }
}
