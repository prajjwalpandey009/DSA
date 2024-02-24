package org.example.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    public static void main(String[] args) {
        topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]);
        map.forEach((key, val) -> {
            priorityQueue.add(new int[]{key, val});
        });

        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }
}
