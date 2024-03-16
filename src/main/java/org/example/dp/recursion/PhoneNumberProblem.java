package org.example.dp.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberProblem {

    static Map<Character, char[]> map;

    static {
        map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'q', 'p', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        solveLetterCombination(digits, res, 0, "");
        return res;
    }

    public static void solveLetterCombination(String digit, List<String> res, int start, String curr) {

        //This is max combination i can make
        if (curr.length() == digit.length()) {
            res.add(curr);
            return;
        }

        for (int i = start; i < digit.length(); i++) {
            char[] arr = map.get(digit.charAt(i));
            for (char c : arr) {
                //Adding the char
                curr = curr + c;

                solveLetterCombination(digit, res, i + 1, curr);

                //Removing the letter
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }
}
