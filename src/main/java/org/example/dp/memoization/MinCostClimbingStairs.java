package org.example.dp.memoization;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        Integer[] dp = new Integer[cost.length];
        int length = cost.length;
        int startIsZero = solve(cost, 0, length, dp);
        int startIsOne = solve(cost, 1, length, dp);
        return Math.min(startIsOne, startIsZero);
    }

    public static int solve(int[] cost, int start, int length, Integer[] dp) {
        if (start >= length) {
            return 0;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        int take1 = cost[start] + solve(cost, start + 1, length, dp);
        int take2 = cost[start] + solve(cost, start + 2, length, dp);
        dp[start] = Math.min(take2, take1);
        return dp[start];
    }
}
