package org.example.array;


public class FindMaxProductSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3, -1, 4}));
    }

    public static int maxProduct(int[] nums) {
        //start multiply from left
        int maxl = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curr != 0) {
                curr *= nums[i];
            } else {
                curr = nums[i];
            }
            maxl = Math.max(maxl, curr);
        }

        //start multiply from right also
        int maxr = nums[nums.length - 1];
        curr = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (curr != 0) {
                curr *= nums[i];
            } else {
                curr = nums[i];
            }
            maxr = Math.max(maxr, curr);
        }

        //Then compare it
        return Math.max(maxl, maxr);
    }
}
