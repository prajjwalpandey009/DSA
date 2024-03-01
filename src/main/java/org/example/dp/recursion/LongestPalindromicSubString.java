package org.example.dp.recursion;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("", "eabcb"));
    }

    public static String longestPalindrome(String longest, String current) {
        if (isPallindrome(current)) {
            longest = current.length() > longest.length() ? current : longest;
        }
        if (current.length() == 1) {
            return longest;
        }
        String removeLast = longestPalindrome(longest, current.substring(0, current.length() - 1));
        String removeFirst = longestPalindrome(longest, current.substring(1));
        return removeFirst.length() > removeLast.length() ? removeFirst : removeLast;
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
