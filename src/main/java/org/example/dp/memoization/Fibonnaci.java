package org.example.dp.memoization;

//In this approach we have used memoization technique to solve
//the problem

public class Fibonnaci {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }


    public static int fib(int n) {
        Integer[] dp = new Integer[n + 1];
        return findFibo(dp, n);
    }

    private static int findFibo(Integer[] dp, int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        dp[n] = findFibo(dp, n - 1) + findFibo(dp, n - 2);
        return dp[n];
    }
}
