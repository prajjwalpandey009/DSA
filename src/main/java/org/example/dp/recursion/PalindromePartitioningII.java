package org.example.dp.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }

    public static int minCut(String s) {
        List<String> list = new ArrayList<>();

        return solveMinCut(s, 0, list);
    }

    private static int solveMinCut(String s, int start, List<String> list) {
        if (start >= s.length()) {
            return list.size()-1;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                ans = Math.min(ans, solveMinCut(s, i + 1, list));
                list.remove(list.size() - 1);
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
