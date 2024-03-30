package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubArrayWithKFrequency {

    public static void main(String[] args) {
        maxSubarrayLength(new int[]{}, 2);
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while (i < nums.length) {

            //acquire
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            //release
            if (map.getOrDefault(nums[i], 0) > k) {
                while (map.getOrDefault(nums[i], 0) > k && j <= i) {
                    map.put(nums[j], map.getOrDefault(nums[j], 1) - 1);
                    j++;
                }
            }

            //its also calculate length as well
            max = Math.max(max, i - j + 1);

            i++;

        }
        return max;
    }
}
