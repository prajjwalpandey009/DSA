package org.example.slidingwindow;

public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {

        //algo
        //1- first need to identify the position of k-min index postion
        //2- Second you need to identify the k-max index postion
        //3- Third you need to identify culprit index
        //5 -Initialise all those variable with -1;
        //6- calculate all the possible sub array during this process by formula
        // min of (MaxK, MinK) + culprit index
        //you will get your answer
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {

        int minIndex = -1;
        int maxIndex = -1;
        int invalidIndex = -1;

        long ans = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < minK || nums[i] > maxK) {
                invalidIndex = i;
            }

            if (nums[i] == minK) {
                minIndex = i;
            }

            if (nums[i] == maxK) {
                maxIndex = i;
            }

            int min = Math.min(minIndex, maxIndex);
            int temp = min - invalidIndex;
            ans += Math.max(temp, 0);
        }
        return ans;
    }
}
