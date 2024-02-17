package org.example.twopointer;

public class TrappingRainWater {

    public static void main(String[] args) {
        int ans = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(ans);
    }

    public static int trap(int[] height) {
        int[] leftmax = new int[height.length];
        leftmax[0] = height[0];
        int result = 0;

        int[] rightmax = new int[height.length];
        rightmax[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
            rightmax[height.length - 1 - i] = Math.max(height[height.length - 1 - i], rightmax[height.length - 1 - i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            result += Math.min(leftmax[i], rightmax[i]) - height[i];
        }
        return result;
    }

}
