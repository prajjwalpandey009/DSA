package org.example.dp.recursion;

public class WildcardMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("prajjwal", "pra?*al"));
    }

    public static boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return solveWildCard(s, p, 0, 0, dp);
    }

    private static boolean solveWildCard(String s, String p, int i, int j, Boolean[][] dp) {
        // Base case: if both strings are exhausted
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        // Base case: if pattern is exhausted, but string is not
        if (j >= p.length()) {
            return false;
        }
        // Base case: if string is exhausted, check if remaining pattern consists of only '*'
        if (i >= s.length()) {
            while (j < p.length()) {
                if (p.charAt(j) != '*') {
                    return false;
                }
                j++;
            }
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == p.charAt(j) || '?' == p.charAt(j)) {
            return dp[i][j] = solveWildCard(s, p, i + 1, j + 1, dp);
        } else if ('*' == p.charAt(j)) {
            return dp[i][j] = solveWildCard(s, p, i, j + 1, dp) || solveWildCard(s, p, i + 1, j, dp);
        }
        return false;
    }
}
