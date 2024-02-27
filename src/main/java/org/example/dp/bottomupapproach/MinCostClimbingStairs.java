package org.example.dp.bottomupapproach;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        //lets assign the meaning that dp[i] is the minimum cost to reach end of array
        int[] dp = new int[cost.length];

        dp[cost.length - 1] = cost[cost.length - 1];
        dp[cost.length - 2] = cost[cost.length - 2];
        int end = cost.length - 3;
        while (end >= 0) {
            dp[end] = cost[end] + Math.min(dp[end + 1], dp[end + 2]);
            end--;
        }
        // we can start from either one and two
        return Math.min(dp[0], dp[1]);
    }

}
