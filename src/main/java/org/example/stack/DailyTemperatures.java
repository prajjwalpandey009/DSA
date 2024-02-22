package org.example.stack;

import java.util.Stack;

//Algo
//Use stack to do this in linear time
//Maintain one stack in which store the index of element
//If you found bigger value in next element as compare to stack peek just pop it
//take the difference of index and store in answer array
//repeat until you got value for all the indexes
public class DailyTemperatures {
    public static void main(String[] args) {
        dailyTemperaturesByNextGreaterApproach(new int[]{30, 50, 50, 60});
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {

            //checking if next value is greater or not
            //Iterate and get answer for all the element
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                //Take the differences of index and you will have days as per you answer
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }

    public static int[] dailyTemperaturesByNextGreaterApproach(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int length = temperatures.length - 2;
        //last index is present in length+1;
        ans[length + 1] = 0;
        //Pushed the last index
        stack.push(length + 1);
        while (length >= 0) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[length]) {
                stack.pop();
            }
            if (stack.isEmpty()) {

            } else {
                ans[length] = stack.peek() - length;
            }
            stack.push(length);
            length--;
        }
        return ans;
    }
}
