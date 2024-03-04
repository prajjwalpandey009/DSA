package org.example.dp.recursion;

;

public class isSubSequence {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(isSubsequence("", "abcde"));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static boolean isSubsequence(String s, String t) {
        int start = 0;
        int start2 = 0;
        int count = 0;
        while (start2 < t.length() && start < s.length()) {
            if (s.charAt(start) == t.charAt(start2)) {
                start++;
                count++;
            }
            start2++;
        }
        if (count == s.length()) {
            return true;
        }
        return false;
    }
}
