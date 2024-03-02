package org.example.dp.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static void main(String[] args) {
        generateParenthesis(6);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        solveGenerateParenthesis(n, list, "");
        return list;
    }

    private static void solveGenerateParenthesis(int n, List<String> list, String s) {
        if (n == 0) {
            if (isValidParenthesis(s)) {
                list.add(s);
            }
            return;
        }
        solveGenerateParenthesis(n - 1, list, s + "(");
        solveGenerateParenthesis(n - 1, list, s + ")");
    }

    private static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}
