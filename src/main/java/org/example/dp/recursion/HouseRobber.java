package org.example.dp.recursion;

public class HouseRobber {
    public static void main(String[] args) {

    }

    public static int rob(int[] nums) {
        int n = nums.length;
        return solve(nums, 0, n);
    }

    private static int solve(int[] nums, int i, int n) {
        if (i >= n) {
            return 0;
        }
        //If steal the money so add it and then move to house next to adjacent
        int steal = nums[i] + solve(nums, i + 2, n);

        //If skip the money dont add anything just move to next house
        int skip = solve(nums, i + 1, n);

        return Math.max(steal, skip);
    }
}
