package org.example.prefix;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        //Algo
        //Assume 0's as -1 first
        //then iterate all the elements of the arrays and maintain the sum
        //check if the current sum at every index is exist in the map
        //if exist then calculate differance in the index and if longest mark this as ans
        findMaxLength(new int[]{0, 1, 0});
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLength = 0;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currSum += -1;
            } else {
                currSum += 1;
            }

            if (map.get(currSum) != null) {
                maxLength = Math.max(maxLength, i - map.get(currSum));
            } else {
                map.put(currSum, i);
            }
        }
        return maxLength;
    }
}
