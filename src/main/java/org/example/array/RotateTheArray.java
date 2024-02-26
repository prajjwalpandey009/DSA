package org.example.array;


public class RotateTheArray {
    public static void main(String[] args) {

        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    //Approach without any extra space complexity O(1)
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;

        if (k == 0) {
            return;
        }

        // 1 2 3 4 5 6 7
        reverse(nums, 0, nums.length - 1);
        //7 6 5 4 3 2 1

        //Again call reverse from 0 to k and the again k+1 to end
        //let assume k = 3
        //reverse 7 6 5 to 5 6 5 and k+1 to end reverse again so 1 2 3 4
        //final 7 6 5 1 2 3 4
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
