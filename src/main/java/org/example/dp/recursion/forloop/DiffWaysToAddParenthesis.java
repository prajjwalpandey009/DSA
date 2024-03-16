package org.example.dp.recursion.forloop;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToAddParenthesis {
    public static void main(String[] args) {
        diffWaysToCompute("2+2*2");
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String leftExpr = expression.substring(0, i);
                String rightExpr = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(leftExpr);
                List<Integer> rightResults = diffWaysToCompute(rightExpr);

                for (int left : leftResults) {
                    for (int right : rightResults) {
                        int computed = 0;
                        switch (ch) {
                            case '+':
                                computed = left + right;
                                break;
                            case '-':
                                computed = left - right;
                                break;
                            case '*':
                                computed = left * right;
                                break;
                        }
                        result.add(computed);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }


}
