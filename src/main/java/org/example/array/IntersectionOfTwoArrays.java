package org.example.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setOfNums = new HashSet<>();
        for (int i : nums2) {
            setOfNums.add(i);
        }
        Set<Integer> ans = new HashSet<>();
        for (int i : nums1) {
            if (setOfNums.contains(i)) {
                ans.add(i);
            }
        }
        int[] ansArray = new int[ans.size()];
        int i = 0;
        for (Integer an : ans) {
            ansArray[i] = an;
            i++;
        }
        return ansArray;
    }
}
