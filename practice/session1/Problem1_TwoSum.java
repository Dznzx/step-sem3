/*
 * Category C - Problem L1: Two Sum
 * Finds the indices of the two array elements that sum to a target value,
 * using a brute-force nested-loop pairwise check.
 */
public class Problem1_TwoSum {

    public static void main(String[] args) {
        printResult(twoSum(new int[] {2, 7, 11, 15}, 9));
        printResult(twoSum(new int[] {3, 2, 4}, 6));
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No valid pair found for target " + target);
    }

    private static void printResult(int[] indices) {
        System.out.println("[" + indices[0] + ", " + indices[1] + "]");
    }
}
