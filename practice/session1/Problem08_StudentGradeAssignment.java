/*
 * Problem 8: Student Grade Assignment
 * Maps marks out of 100 to a grade with an if-else ladder from the highest boundary down.
 */
import java.util.Scanner;

public class Problem08_StudentGradeAssignment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            System.out.println("Grade " + gradeFor(scanner.nextInt()));
        }
    }

    private static char gradeFor(int marks) {
        if (marks >= 90) return 'A';
        if (marks >= 75) return 'B';
        if (marks >= 60) return 'C';
        if (marks >= 40) return 'D';
        return 'F';
    }
}
