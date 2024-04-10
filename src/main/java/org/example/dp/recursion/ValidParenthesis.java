package org.example.dp.recursion;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(checkValidString("(*))"));
    }

    public static boolean checkValidString(String s) {
        Boolean[][] memo = new Boolean[101][101];
        return generateString(s, 0, 0, memo);
    }

    public static boolean generateString(String s, int start, int open, Boolean[][] memo) {

        if (start >= s.length()) {
            return open == 0;
        }

        if (memo[start][open] != null) {
            return memo[start][open];
        }

        if (s.charAt(start) == '*') {
            boolean considerOpen = generateString(s, start + 1, open + 1, memo);
            boolean considerClose = false;
            if (open > 0) {
                considerClose = generateString(s, start + 1, open - 1, memo);
            }
            boolean considerEmpty = generateString(s, start + 1, open, memo);
            memo[start][open] = considerOpen || considerClose || considerEmpty;
            return considerOpen || considerClose || considerEmpty;
        } else if (s.charAt(start) == ')') {
            boolean re = false;
            if (open > 0) {
                re = generateString(s, start + 1, open - 1, memo);
                memo[start][open] = re;
                return re;
            }
            memo[start][open] = re;
            return re;
        }
        boolean res = generateString(s, start + 1, open + 1, memo);
        memo[start][open] = res;
        return res;
    }
}
