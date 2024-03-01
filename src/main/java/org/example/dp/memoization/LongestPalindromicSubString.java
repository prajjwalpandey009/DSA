package org.example.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("caaaaa"));
    }

    public static String longestPalindrome(String s) {
        Map<String, String> dp = new HashMap<>();
        return solvePalindrome("", s, dp);
    }

    public static String solvePalindrome(String longest, String current, Map<String, String> dp) {
        if (isPallindrome(current)) {
            longest = current.length() > longest.length() ? current : longest;
        }
        if (current.length() == 1) {
            return longest;
        }
        if (dp.get(current) != null) {
            return dp.get(current + longest);
        }
        String removeLast = solvePalindrome(longest, current.substring(0, current.length() - 1), dp);
        String removeFirst = solvePalindrome(longest, current.substring(1), dp);

        String ans = "";
        if (removeLast != null && removeFirst != null) {
            ans = removeFirst.length() > removeLast.length() ? removeFirst : removeLast;
        } else if (removeFirst == null) {
            ans = removeLast;
        }else {
            ans = removeFirst;
        }

        dp.put(current + longest, ans);

        return dp.get(current + longest);
    }

    private static boolean isPallindrome(String current) {
        int i = 0;
        int j = current.length() - 1;
        while (i < j) {
            if (current.charAt(i) != current.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
