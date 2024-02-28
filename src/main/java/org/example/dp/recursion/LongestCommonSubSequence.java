package org.example.dp.recursion;

//https://www.youtube.com/watch?v=aJNu_DLyOxY
//First match both character of string if matched then increment it
//Otherwise increment both character of string by one and then check
//Do for other string also and check and take the maximum of it
public class LongestCommonSubSequence {
    public static void main(String[] args) {

    }

    public static int longestCommonSubsequence(String text1, String text2) {
        return getLongestCommonSubsequence(text1, text2, 0, 0);
    }

    private static int getLongestCommonSubsequence(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + getLongestCommonSubsequence(text1, text2, i + 1, j + 1);
        } else {
            return Math.max(getLongestCommonSubsequence(text1, text2, i + 1, j),
                    getLongestCommonSubsequence(text1, text2, i, j + 1));
        }
    }

}
