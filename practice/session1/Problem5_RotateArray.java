/*
 * Category C - Problem L5: Rotate Array
 * Rotates an array to the right by k positions by computing each
 * element's new position directly, using modulo for wraparound.
 */
import java.util.Arrays;

public class Problem5_RotateArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[] {1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(rotateArray(new int[] {1, 2}, 3)));
    }

    private static int[] rotateArray(int[] nums, int k) {
        int rotateBy = k % nums.length;
        int[] rotated = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            rotated[(i + rotateBy) % nums.length] = nums[i];
        }

        return rotated;
    }
}
