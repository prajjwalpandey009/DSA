package org.example.array;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int window = 0;
        for (int i = 0; i < nums.length; i++) {
            if (window < k) {
                //window is empty
                pq.add(nums[i]);
                window++;
            } else {
                //we have the complete window so only heapify if next element is greater
                if (!pq.isEmpty() && pq.peek() <= nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.poll();
    }
}
