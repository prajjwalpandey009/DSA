package org.example.dp.bottomupapproach;

//Here we have used bottom up approach and solving problem
//smaller first and then moving to bigger one and utilising the result

public class Fibonnaci {
    public static void main(String[] args) {
        System.out.println(fib(6));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1] + dp[n - 2];
    }

}
