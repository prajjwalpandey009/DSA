package org.example.prefix;

import java.util.HashMap;
import java.util.Map;

public class NumOFSubarraysWithTargetSum {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {

        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        // Initial sum is 0 has occurred once
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            sum += num;

            // checking that if sub array exist or not if exist then we can easily
            // say that by removing it we can get the goal of target sum
            count += prefixSumCount.getOrDefault(sum - goal, 0);

            // Update prefix sum count so we can check further we have that array or not
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
