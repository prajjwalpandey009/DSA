package org.example.dp.recursion;

import java.util.ArrayList;
import java.util.List;

public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        doPartition(nums, k, 0, sublist, list);
        System.out.println(list);
        return true;
    }

    private static void doPartition(int[] nums, int k, int start, List<Integer> sublist, List<List<Integer>> list) {
        if (start == nums.length - 1) {
            System.out.println(sublist);
            list.add(new ArrayList<>(sublist));
            return;
        }

        sublist.add(nums[start]);
        doPartition(nums, k, start + 1, sublist, list);
        //removed for back tracking
        sublist.remove(sublist.size() - 1);
        doPartition(nums, k, start + 1, sublist, list);
    }
}
