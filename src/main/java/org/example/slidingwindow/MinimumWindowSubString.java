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
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        String ans = "";
        int mtc = 0;
        int dmtc = t.length();

        Map<Character, Integer> smap = new HashMap<>();

        while (i < s.length()) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
            if (smap.getOrDefault(s.charAt(i), 0) <= map.getOrDefault(s.charAt(i), 0)) {
                mtc++;
            }

            while (mtc >= dmtc) {
                if(ans.isEmpty() || ans.length() > s.substring(j, i).length()){
                    ans = s.substring(j, i+1);
                }
                smap.put(s.charAt(j), smap.getOrDefault(s.charAt(j), 1) - 1);
                if(map.getOrDefault(s.charAt(j), 0) > smap.getOrDefault(s.charAt(j), 0)){
                    mtc--;
                }
                j++;
            }
            i++;
        }

        return ans;
    }


}
