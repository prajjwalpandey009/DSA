package org.example.slidingwindow;

public class ProductOfSubArrayLessThanK {
    public static void main(String[] args) {
        numSubarrayProductLessThanK(new int[]{}, 0);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int pr = 1;
        int count = 0;
        while (i < nums.length) {
            pr *= nums[i];
            while (pr >= k) {
                pr /= nums[j];
                j++;
            }
            //It will calculate all the possible sub array
            count += (i - j + 1);
            i++;
        }

        return count;
    }
}
