/*
 * Category C - Problem L3: Contains Duplicate
 * Nested-loop pairwise comparison with an early exit as soon as a
 * duplicate value is found.
 */
public class Problem3_ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] {1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[] {1, 2, 3, 4}));
    }

    private static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
