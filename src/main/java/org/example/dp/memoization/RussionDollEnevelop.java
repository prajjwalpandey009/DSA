package org.example.dp.memoization;

import java.util.Arrays;
import java.util.Comparator;

public class RussionDollEnevelop {
    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Integer[][] dp = new Integer[envelopes.length][envelopes.length];
        //start from index 0;
        Arrays.sort(envelopes, Comparator.comparingInt(n -> n[0]));
        return solve(envelopes, 0, -1, dp);
    }

    public static int solve(int[][] envelopes, int start, int prev, Integer[][] dp) {
        if (start >= envelopes.length) {
            return 0;
        }
        int include = 0;
        if (prev != -1 && dp[start][prev] != null) {
            return dp[start][prev];
        }
        if (prev == -1 || envelopes[prev][0] < envelopes[start][0] && envelopes[prev][1] < envelopes[start][1]) {
            include = 1 + solve(envelopes, start + 1, start, dp);
        }
        int notInclude = solve(envelopes, start + 1, prev, dp);
        if (prev != -1) {
            dp[start][prev] = Math.max(include, notInclude);
            return dp[start][prev];
        }
        return Math.max(include, notInclude);
    }
}
