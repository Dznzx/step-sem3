/*
 * Category C Assignment - Problem A2: Maximum Subarray
 * Kadane's algorithm: at each element decide whether to extend the
 * current running subarray or restart from the current element.
 */
public class Homework2_MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[] {-3, -1, -2}));
    }

    private static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int bestSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            bestSum = Math.max(bestSum, currentSum);
        }

        return bestSum;
    }
}
