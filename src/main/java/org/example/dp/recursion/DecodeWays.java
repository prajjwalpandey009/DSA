package org.example.dp.recursion;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("10"));
    }

    public static int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return solveDecode(s, 0, dp);
    }

    private static int solveDecode(String s, int start, Integer[] dp) {

        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        if (dp[start] != null) {
            return dp[start];
        }

        int takeOne = solveDecode(s, start + 1, dp);

        int takeTwo = 0;
        if (start + 1 < s.length() && (s.charAt(start) == '1' || s.charAt(start) == '2' && s.charAt(start + 1) <= '6')) {
            takeTwo = solveDecode(s, start + 2, dp);
        }

        return dp[start] = takeOne + takeTwo;
    }
}
