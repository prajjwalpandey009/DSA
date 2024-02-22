package org.example.stack;

import java.util.Stack;

//Algo
//First try to find out the smallest possible number from the left
//by iterating over the array

//Then start traversing from the end, so you will get the maximum difference
//if stack peek is smaller than end so pop end repeat it and if end is smaller than peek decrease the end
//do until your stack element is empty or you have reached to 0

public class MaxWidthRamp {
    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

    //put the smallest element at left
    public static int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        //start finding bigger element from right so get the maximum difference as width
        int end = nums.length - 1;
        int maxwidth = 0;
        while (!stack.isEmpty() && end >= 0) {
            if (nums[stack.peek()] <= nums[end]) {
                maxwidth = Math.max(maxwidth, end - stack.peek());
                stack.pop();
            } else {
                end--;
            }
        }
        return maxwidth;
    }


    //Solve by checking max element from right


}