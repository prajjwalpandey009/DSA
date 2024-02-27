package org.example.dp.memoization;

public class HouseRobber {
    public static void main(String[] args) {

    }

    public static int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length + 1];
        int n = nums.length;
        return solve(nums, 0, n, dp);
    }

    private static int solve(int[] nums, int i, int n, Integer[] dp) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int steal = nums[i] + solve(nums, i + 2, n, dp);
        int skip = solve(nums, i + 1, n, dp);
        dp[i] = Math.max(steal, skip);
        return dp[i];
    }
}
