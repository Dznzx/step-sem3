/*
 * Problem 9: Leap Year Detector
 * Divisible by 4 and not by 100, unless also divisible by 400.
 */
import java.util.Scanner;

public class Problem09_LeapYearDetector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            System.out.println(isLeapYear(scanner.nextInt()) ? "Leap year" : "Not a leap year");
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
