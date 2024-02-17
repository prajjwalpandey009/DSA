package org.example.greedy;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {

        //Start traversing from last index;

        boolean[] result = new boolean[nums.length];
        result[nums.length - 1] = true;

        //start from second last because for last index is always pointing to the destination
        int end = nums.length - 2;
        while (end >= 0) {
            //Take reference staring point.
            int start = end;

            //step counter
            int count = nums[end];

            while (count >= 0 && start <= nums.length - 1) {
                if (result[start] == true) {
                    result[end] = true;
                    break;
                }
                start++;
                count--;
            }
            end--;
        }
        return result[0];
    }
}
