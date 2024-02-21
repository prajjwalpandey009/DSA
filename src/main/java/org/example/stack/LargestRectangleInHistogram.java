package org.example.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> lstack = new Stack<>();
        int max = 0;

        //next smaller element on left
        int[] nsel = new int[heights.length];
        lstack.push(0);
        nsel[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            while (!lstack.isEmpty() && heights[i] <= heights[lstack.peek()]) {
                lstack.pop();
            }
            if (lstack.isEmpty()) {
                nsel[i] = -1;
            } else {
                nsel[i] = lstack.peek();
            }
            lstack.push(i);
        }


        Stack<Integer> rstack = new Stack<>();
        //next smaller element on right
        int[] nser = new int[heights.length];
        rstack.push(heights.length - 1);
        nser[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            while (!rstack.isEmpty() && heights[i] <= heights[rstack.peek()]) {
                rstack.pop();
            }
            if (rstack.isEmpty()) {
                nser[i] = heights.length;
            } else {
                nser[i] = rstack.peek();
            }
            rstack.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            //we have added one extra index because of smaller element
            //its not a part of width so added -1
            int width = nser[i] - nsel[i] - 1;
            int area = width * heights[i];
            max = Math.max(area, max);
        }
        return max;
    }
}
