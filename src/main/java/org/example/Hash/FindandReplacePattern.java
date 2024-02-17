package org.example.Hash;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindandReplacePattern {
    public static void main(String[] args) {
        String[] list = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(list, pattern));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> word = new ArrayList<>();
        String patternString = getNormaliseString(pattern);
        for (String s : words) {
            String normalise = getNormaliseString(s);
            if (normalise.equals(patternString)) {
               word.add(s);
            }
        }
        return word;
    }

    private static String getNormaliseString(String pattern) {
        String s = "";
        Map<Character, Integer> maps = new LinkedHashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            maps.put(pattern.charAt(i), maps.getOrDefault(pattern.charAt(i), i));
            s += maps.get(pattern.charAt(i));
        }
        return s;
    }

}
