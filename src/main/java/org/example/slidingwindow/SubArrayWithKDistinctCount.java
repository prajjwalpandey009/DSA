package org.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinctCount {

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
    }

    public static int slidingWindow(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        int i = 0;
        int j = 0;

        int count = 0;

        while (i < n) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() > k) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) - 1);
                if (map.getOrDefault(nums[j], 0) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }
            count += (i - j + 1);
            i++;
        }
        return count;
    }
}
