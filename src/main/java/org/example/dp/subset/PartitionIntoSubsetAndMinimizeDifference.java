package org.example.dp.subset;

import java.util.Arrays;

//Algo try to find out all the possible subset sum
//and then calcuate the difference
//Instead of this we can go with dp approach
public class PartitionIntoSubsetAndMinimizeDifference {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{3,9,7,3}));
    }

    public static int minimumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = Arrays.stream(nums).sum();
        for (int i = 1; i <= sum / 2; i++) {
            boolean res = subSetSum(nums, 0, i);
            if (res) {
                //sum of second subset is
                int otherSubset = (sum - i);
                min = Math.min(min, otherSubset - i);
            }
        }
        return min;
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
