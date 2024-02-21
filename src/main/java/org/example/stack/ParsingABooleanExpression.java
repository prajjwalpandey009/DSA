package org.example.stack;

import java.util.Stack;

public class ParsingABooleanExpression {
    public static void main(String[] args) {
        System.out.println(parseBoolExpr("|(f,f,f,t)"));
    }

    public static boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) != ')') {
                stack.push(expression.charAt(i));
            } else {
                String sub = "";

                //extract the substring until reach to opening bracket
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sub = stack.pop() + sub;
                }
                //removed the peek bracket also
                stack.pop();

                char operationAns;

                //Pop the operation also
                char performOp = stack.pop();

                if (performOp == '&') {
                    operationAns = andOperation(sub);
                } else if (performOp == '!') {
                    operationAns = sub.charAt(0) == 't' ? 'f' : 't';
                } else {
                    operationAns = orOperation(sub);
                }
                stack.push(operationAns);
            }
        }

        return stack.pop() == 't';
    }


    //IF any character contains true it will return true
    public static char orOperation(String s) {
        boolean result = false; // Initialize result to false
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 't') {
                result = true; // If any character is true, set result to true
                break; // Exit the loop early as the result is already true
            }
        }
        return result ? 't' : 'f';
    }

    //IF any character contains false it will return false
    public static char andOperation(String s) {
        boolean result = true; // Initialize result to true
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'f') {
                result = false; // If any character is false, set result to false
                break; // Exit the loop early as the result is already false
            }
        }
        return result ? 't' : 'f';
    }

}
