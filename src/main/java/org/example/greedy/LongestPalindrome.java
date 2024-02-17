package org.example.greedy;

import java.util.HashMap;
import java.util.Map;

//Mathematical problem
//So think like that what help you to make string as palindrome string
//Even number of character plus one add character.
//store all the count of character
//Then iterate and check for even and add its length plus one odd character
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int even = 0;
        int odd = 0;
        for (Character key : map.keySet()) {

            //It will make sure that only even length is included
            //7/2 = 3 *2 = 6 so in length of 7 only even length 6 is included in result
            even = even + (map.get(key) / 2) * 2;

            //Adding check of zero to make sure that it enters one time
            //because of palindrome string at most one odd character
            if (odd == 0 && map.get(key) % 2 != 0) {
                odd++;
            }
        }

        return even + odd;
    }
}
