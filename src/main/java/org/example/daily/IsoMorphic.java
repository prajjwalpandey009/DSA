package org.example.daily;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (map.get(s.charAt(i)) == null && map2.get(t.charAt(j)) == null) {
                map.put(s.charAt(i), t.charAt(j));
                map2.put(t.charAt(j), s.charAt(i));
            } else {
                if (map.get(s.charAt(i)) == null || map2.get(t.charAt(j)) == null) {
                    return false;
                } else if (map.get(s.charAt(i)) == t.charAt(j)) {

                } else {
                    return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }
}
