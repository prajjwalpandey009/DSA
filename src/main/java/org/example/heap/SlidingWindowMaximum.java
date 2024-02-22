package org.example.heap;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1}, 1);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        //K is window size so we are checking how much window we will make
        int ansSize = 0;

        //(n-k+1) this much wondow is possible if we incrementing window one by one over the array
        ansSize = nums.length - k + 1;


        int[] ans = new int[ansSize];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> n2 - n1);

        int count = 0;

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < k) {
                priorityQueue.add(nums[i]);
                count++;
            } else {
                ans[start] = priorityQueue.peek();
                //calculating index of previous number from current
                priorityQueue.remove(nums[i - k]);
                priorityQueue.add(nums[i]);
                start++;
            }
        }
        ans[start] = priorityQueue.peek();
        return ans;
    }
}
