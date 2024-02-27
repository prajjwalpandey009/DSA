package org.example.dp.bottomupapproach;

public class ClimibingStair {
    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return findClimbing(n, dp);
    }

    public static int findClimbing(int n, int[] dp) {
        if (n == 1 || n == 2) {
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;


        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1] + dp[n - 2];
    }
}
