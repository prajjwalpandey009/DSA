package org.example.dp.recursion;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        boolean[] visted = new boolean[nums.length];
        return subSetSum(nums, 0, sum / k, visted, k);
    }

    public static boolean subSetSum(int[] nums, int start, int target, boolean[] visted, int k) {

        //when target is achived
        if (k == 0) {
            return true;
        }
        if (target == 0) {
            //Again start from 0
            return subSetSum(nums, 0, target, visted, k - 1);
        }

        //when target is not achieved and target reached to less than 0
        if (target < 0) {
            return false;
        }
        //start cross the over all length
        if (start >= nums.length) {
            return false;
        }

        boolean take = false;
        if (visted[start] == false) {
            visted[start] = true;
            take = subSetSum(nums, start + 1, target - nums[start], visted, k);
            visted[start] = false;
        }

        boolean notTake = subSetSum(nums, start + 1, target, visted, k);
        return take || notTake;
    }

}
