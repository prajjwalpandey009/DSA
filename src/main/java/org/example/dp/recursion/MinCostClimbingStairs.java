package org.example.dp.recursion;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int startIsZero = solve(cost, 0, length);
        int startIsOne = solve(cost, 1, length);
        return Math.min(startIsOne, startIsZero);
    }

    public static int solve(int[] cost, int start, int length) {
        if (start >= length) {
            return 0;
        }
        int take1 = cost[start] + solve(cost, start + 1, length);
        int take2 = cost[start] + solve(cost, start + 2, length);
        return Math.min(take2, take1);
    }
}
