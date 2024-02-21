package org.example.stack;

import java.util.Stack;

public class DecodeStringInSquareBracket {
    public static void main(String[] args) {
        System.out.println(decodeString("3[ab]"));
    }

    public static String decodeString(String s) {
        String ans = "";
        Stack<Character> stack = new Stack<>();
        //Pushing all element in a stack until we have reached to closing bracket
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                String sub = "";
                //Pop the stack until we have reached to opening bracket
                while (stack.peek() != '[') {
                    sub = stack.pop() + sub;
                }
                //last pop for the bracket
                stack.pop();

                String num = "";
                //again start poping untill we have number as character which is number;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num = stack.pop() + num;
                }

                // Again adding all those character of sub string in stack upto k times as num
                for (int k = 0; k < Integer.valueOf(num); k++) {
                    for (int j = 0; j < sub.length(); j++) {
                        stack.push(sub.charAt(j));
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        return ans;
    }
}
