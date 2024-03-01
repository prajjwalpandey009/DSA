package org.example.dp.subset;

import java.util.Arrays;

//Algo
//lets take the total sum of all the elements
//check the sum is even and odd
//if sum is odd then two subset set has never been the same values
//in case of even just try to find out the subset whose sum is equal to sum/2

public class DivideIntoTwoSubSetWhoseSumIsEqual {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 4,5,6,7}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        return subSetSum(nums, 0, sum / 2);
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
