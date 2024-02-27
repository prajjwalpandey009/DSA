package org.example.dp.bottomupapproach;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //lets move to bottom up approach
        //assign meaning to dp array
        //dp[i] is the maximum amount of money that robber can robber
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int steal = nums[i] + dp[i - 2];
            int skip = dp[i - 1];
            dp[i] = Math.max(steal, skip);
        }
        return dp[nums.length - 1];
    }
}
