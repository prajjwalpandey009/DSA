package org.example.stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        //algo
        //put all the character in an array
        //then start traversing string and check that pair is valid or not using stack
        //put that character is empty who is invalid
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }


    public static String minRemoveToMakeValid(String s) {

        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    arr[i] = '.';
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = '.';
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != '.') {
                builder.append(arr[i]);
            }
            i++;
        }
        return builder.toString();
    }
}
