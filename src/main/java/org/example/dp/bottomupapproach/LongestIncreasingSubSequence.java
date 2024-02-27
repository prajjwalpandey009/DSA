package org.example.dp.bottomupapproach;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    public static int lengthOfLIS(int[] nums) {
        //lets assign the meaning
        //dp[i] is the maximum possible of LSI(lowest common possible subsequence at
        // ith index
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
