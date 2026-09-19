/*
 * Category C Assignment - Problem A4: Subarray Sum Equals K
 * Counts contiguous subarrays summing to k using running prefix sums and
 * a hash map of prefix-sum frequencies (works correctly with negatives).
 */
import java.util.HashMap;
import java.util.Map;

public class Homework4_SubarraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {1, 1, 1}, 2));
        System.out.println(subarraySum(new int[] {1, -1, 0}, 0));
    }

    private static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            count += prefixSumFrequency.getOrDefault(currentSum - k, 0);
            prefixSumFrequency.put(currentSum, prefixSumFrequency.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
