/*
 * Week 1 Assignment - Problem 1: Exam Hall Seat Duplication Checker
 * Scans an array of assigned seat numbers with nested loops (no Collections
 * classes) and reports any duplicate seat numbers found.
 */
public class Homework1_ExamHallSeatDuplicationChecker {

    public static void main(String[] args) {
        checkDuplicateSeats(new int[] {101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[] {101, 102, 103, 104, 105});
    }

    private static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                }
            }
        }
        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
