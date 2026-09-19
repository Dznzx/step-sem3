/*
 * Category C Assignment - Problem A5: Find Minimum in Rotated Sorted Array
 * Modified binary search: at each step compare the middle element to the
 * rightmost element to decide which half contains the minimum.
 */
public class Homework5_FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[] {11, 13, 15, 17}));
    }

    private static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
