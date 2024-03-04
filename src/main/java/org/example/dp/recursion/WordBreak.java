package org.example.dp.recursion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("bb", List.of("a", "abc", "b", "cd")));
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Map<String, Boolean>> dp = new HashMap<>();
        return solveBreakWord(s, wordDict, 0, dp);
    }

    private static boolean solveBreakWord(String s, List<String> wordDict, int start, Map<Integer, Map<String, Boolean>> dp) {
        if (start >= s.length()) {
            return true;
        }
        boolean res = false;

        if (dp.get(start) != null && dp.get(start).get(s) != null) {
            return dp.get(start).get(s);
        }

        for (String word : wordDict) {
            if (res) {
                return true;
            }
            if (word.length() > s.length() - start) {
                continue;
            }
            int count = 0;
            for (int i = start; i < word.length() + start; i++) {
                if (word.charAt(i - start) == s.charAt(i)) {
                    count++;
                } else {
                    break;
                }
            }
            if (word.length() == count) {
                res = solveBreakWord(s, wordDict, start + count, dp);
            }
        }

        if (dp.get(start) == null) {
            Map<String, Boolean> map = new HashMap<>();
            map.put(s, res);
            dp.put(start, map);
        } else {
            dp.get(start).put(s, res);
        }
        return res;
    }
}
