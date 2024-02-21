package org.example.linkedlist;

public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }

    public static int jump(int[] nums) {
        //to maintain minimum jump from each index
        Integer[] minjump = new Integer[nums.length];
        minjump[nums.length - 1] = 0;

        int end = nums.length - 2;
        while (end >= 0) {

            if (nums[end] == 0) {
                end--;
                continue;
            }

            Integer min = Integer.MAX_VALUE;

            //Number of step it can move
            int count = nums[end];

            //Start from next point
            int start = end + 1;

            //checking step count and array bound in while loop
            while (count > 0 && start <= nums.length - 1) {
                if (minjump[start] != null) {
                    min = Math.min(min, minjump[start]);
                }
                start++;
                count--;
            }
            minjump[end] = min == Integer.MAX_VALUE ? null : Integer.valueOf(1 + min);
            end--;
        }
        return minjump[0];
    }
}
