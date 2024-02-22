package org.example.stack;

import java.util.Stack;

public class RemoveAllDuplicateFromString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("azxxzy"));
    }

    public static String removeDuplicates(String s) {
        String ans = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            //If we have peek element as same as char iterating in string
            //just removed it
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                //If element is first time or its not present in stack then put it
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
