package org.example.dp.recursion;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {

        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }

    public static int lengthOfLIS(int[] nums) {
        return solve(nums, 0, -1);
    }

    public static int solve(int[] nums, int index, int prev) {
        if (index >= nums.length) {
            return 0;
        }
        int take = 0;
        if (prev == -1 || nums[prev] < nums[index]) {
            take = 1 + solve(nums, index + 1, index);
        }
        int skip = solve(nums, index + 1, prev);
        return Math.max(take, skip);
    }
}
