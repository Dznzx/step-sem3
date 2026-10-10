/*
 * Assignment Problem 8: Duty Roster Rotation
 * k % n removes full turns, then each name at index i moves to (i + k) % n.
 *
 * Time: O(n), Extra space: O(n) for the rotated copy.
 * Rotating one place at a time k times costs O(n * k); with k up to 10^9 that is
 * billions of shifts, while k % n keeps the work at a single pass.
 */
import java.util.Arrays;

public class Homework08_DutyRosterRotation {

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }

    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }
}
