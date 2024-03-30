package org.example.slidingwindow;

//Algorithm
//1- First calculate frequency of each character in target string
//2- Now iterate second string and start updating the second hashmap and checking that
//   if we have same frequency of character as we have in previous hashmap update match count and previous count
//3- once we have the match count is equal to desired match count then break the loop
//4 - start releasing the element from hashmap and still compare if match count still correct . collect the string.

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }
        //match count
        int mtc = 0;

        //desired match count
        int dmtc = t.length();

        //counter to traverse entire string
        int ct1 = 0;

        int ct2 = 0;

        String cans = "";

        Map<Character, Integer> map2 = new HashMap<>();
        while (ct1 <= s.length() - 1) {
            //acquiring character from string
            map2.put(s.charAt(ct1), map2.getOrDefault(s.charAt(ct1), 0) + 1);
            if (map2.getOrDefault(s.charAt(ct1), 0) <= map1.getOrDefault(s.charAt(ct1), 0)) {
                mtc++;
            }
            //collect and release match count
            while (mtc == dmtc && ct2 <= ct1) {

                //collect
                if (cans.length() == 0 || s.substring(ct2, ct1 + 1).length() < cans.length()) {
                    cans = s.substring(ct2, ct1 + 1);
                }

                //release
                map2.put(s.charAt(ct2), map2.getOrDefault(s.charAt(ct2), 1) - 1);

                //reduce the count
                if (map2.getOrDefault(s.charAt(ct2), 0) < map1.getOrDefault(s.charAt(ct2), 0)) {
                    mtc--;
                }
                ct2++;
            }
            ct1++;
        }
        return cans;
    }


}
