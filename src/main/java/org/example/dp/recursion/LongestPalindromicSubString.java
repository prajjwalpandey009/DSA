package org.example.dp.recursion;


//For subString we have to follow different approach
//Like skip first character from string and then skip last character from string
//Then do this approach repeated manner until last character of string
public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd", "", 0, "cbbd".length()));
    }

    public static String longestPalindrome(String s, String longest, int start, int end) {
        if (start >= end) {
            return longest;
        }
        if (isPallindrome(s.substring(start, end))) {
            if (s.substring(start, end).length() > longest.length()) {
                longest = s.substring(start, end);
            }
        }
        String ansWithSkip1st = longestPalindrome(s, longest, start + 1, end);
        String ansWithSkipLast = longestPalindrome(s, longest, start, end - 1);
        return ansWithSkip1st.length() > ansWithSkipLast.length() ? ansWithSkip1st : ansWithSkipLast;
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
