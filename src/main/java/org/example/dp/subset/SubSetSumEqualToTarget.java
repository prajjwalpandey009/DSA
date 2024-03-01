package org.example.dp.subset;

public class SubSetSumEqualToTarget {
    public static void main(String[] args) {
        System.out.println(subSetSum(new int[]{1, 2, 3, 4}, 0, 11));
    }

    public static boolean subSetSum(int[] nums, int start, int target) {

        //when target is achived
        if (target == 0) {
            return true;
        }

        //when target is not achieved and target reached to less than 0
        if (target < 0) {
            return false;
        }
        //start cross the over all length
        if (start >= nums.length) {
            return false;
        }

        boolean take = subSetSum(nums, start + 1, target - nums[start]);

        boolean notTake = subSetSum(nums, start + 1, target);

        return take || notTake;
    }
}
