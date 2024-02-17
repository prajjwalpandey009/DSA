package org.example.greedy;

import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }

    public static boolean checkValidString(String s) {
        Map<Character, Character> map =
                Map.of('}', '{', ')', '(', ']', '[');
        Stack<Character> stack = new Stack<>();
        Stack<Character> startStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            //pushing all the character with open bracket into stack
            if (s.charAt(i) == '*') {
                startStack.push(s.charAt(i));
            } else if (map.get(s.charAt(i)) == null) {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && stack.peek().equals(map.get(s.charAt(i)))) {
                    stack.pop();
                } else if (startStack.size() != 0) {
                    startStack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
