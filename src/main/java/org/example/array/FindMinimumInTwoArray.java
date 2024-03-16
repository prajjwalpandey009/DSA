package org.example.array;

import java.util.HashSet;
import java.util.Set;

public class FindMinimumInTwoArray {
    public static void main(String[] args) {

        /*
        There are two approaches to find common between two array
        1- take one element into set and perform contains operation on it has O(1)
           time complexity.
        2- take one element from array and perform binary search in other one.
         */
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums2) {
            set.add(i);
        }
        int i = 0;
        while (i <= nums1.length - 1) {
            if (set.contains(nums1[i])) {
                return nums1[i];
            }
            i++;
        }
        return -1;
    }

}
