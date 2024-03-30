package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChar {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int maxLongest = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int secondstart = 0;
        while (start <= s.length() - 1) {
            longest++;
            if (map.get(s.charAt(start)) == null || map.get(s.charAt(start)) == 0) {
                map.put(s.charAt(start), 1);
                maxLongest = Math.max(longest, maxLongest);
            } else {
                map.put(s.charAt(start), 1 + map.get(s.charAt(start)));
                while (secondstart <= start) {
                    map.put(s.charAt(secondstart), map.get(s.charAt(secondstart)) - 1);
                    longest--;
                    if (map.get(s.charAt(secondstart)) == 1) {
                        secondstart++;
                        break;
                    }
                    secondstart++;
                }

            }
            start++;
        }
        return maxLongest;
    }
}
