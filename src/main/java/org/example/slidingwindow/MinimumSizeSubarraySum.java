package org.example.slidingwindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int min = Integer.MAX_VALUE;
        int curr = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            while (curr >= target) {
                min = Math.min(i - j + 1, min);
                curr -= nums[j];
                j++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
