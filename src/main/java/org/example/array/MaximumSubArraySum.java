package org.example.array;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        //Kadan's algo
        //iterate the element
        //add the next element into array if current sum is positive
        //if current sum is negative start the new current sum from there
        //Maintain one over all sum also check with current and update it.
        System.out.println(maxSubArray(new int[]{-1}));
    }


    public static int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (curr >= 0) {
                curr += nums[i];
            } else {
                curr = nums[i];
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
