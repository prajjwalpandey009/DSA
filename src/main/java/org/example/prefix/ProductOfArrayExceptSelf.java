package org.example.prefix;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        productExceptSelf(new int[]{-1, 1, 0, -3, 3});
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        int[] postfix = new int[nums.length];
        postfix[nums.length - 1] = nums[nums.length - 1];

        int i = 1;
        int j = nums.length - 2;
        while (i < nums.length) {
            prefix[i] = prefix[i - 1] * nums[i];
            postfix[j] = postfix[j + 1] * nums[j];
            i++;
            j--;
        }

        for (int k = 0; k < nums.length; k++) {
            int fromPrefix = 1;
            int fromPostfix = 1;
            if (k > 0) {
                fromPrefix = prefix[k - 1];
            }
            if (k < nums.length - 1) {
                fromPostfix = postfix[k + 1];
            }
            nums[k] = fromPrefix * fromPostfix;
        }
        return nums;
    }
}
