package org.example.dp.memoization;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    public static int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length + 1][nums.length + 1];
        return solve(nums, 0, -1, dp);
    }

    public static int solve(int[] nums, int index, int prev, Integer[][] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (prev != -1 && dp[index][prev] != null) {
            return dp[index][prev];
        }
        int take = 0;
        if (prev == -1 || nums[prev] < nums[index]) {
            take = 1 + solve(nums, index + 1, index, dp);
        }
        int skip = solve(nums, index + 1, prev, dp);
        if (prev != -1) {
            dp[index][prev] = Math.max(take, skip);
            return dp[index][prev];
        }
        return Math.max(take, skip);
    }
}
