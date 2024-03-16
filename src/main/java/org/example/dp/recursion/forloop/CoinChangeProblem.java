package org.example.dp.recursion.forloop;

public class CoinChangeProblem {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        int val = solve(coins, amount);
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    private static int solve(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = solve(coins, amount - coins[i]);
            if (ans != Integer.MAX_VALUE) {
                min = Math.min(min, ans + 1);
            }
        }
        return min;
    }
}
