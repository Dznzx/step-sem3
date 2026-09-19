/*
 * Category C Assignment - Problem A1: Product of Array Except Self
 * Computes, for every index, the product of all other elements without
 * using division, via a forward prefix-product pass and a backward
 * suffix-product pass.
 */
import java.util.Arrays;

public class Homework1_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[] {-1, 1, 0, -3, 3})));
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int runningRightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= runningRightProduct;
            runningRightProduct *= nums[i];
        }

        return answer;
    }
}
