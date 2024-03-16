package org.example.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NextPermutation {
    public static void main(String[] args) {

        //algorithm

        //1- First find out the inflexion point(where a[i]<a[i+1]])
        //2- swap it with the minimum of maximum value present till that point
        //3- and now from the inflexion point +1 to end sort all the element


        System.out.println(getPermutation(3, 3));

    }

    public static String getPermutation(int n, int k) {

        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        int[] ans = solvePermutation(nums, k);
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    private static int[] solvePermutation(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        return solvePermutation(nextPermutation(nums), k - 1);
    }

    public static int[] nextPermutation(int[] nums) {
        int end = nums.length - 2;
        int inflexionIndex = 0;
        while (end >= 0) {
            if (nums[end] < nums[end + 1]) {
                inflexionIndex = end;
                break;
            }
            end--;
        }

        int start = inflexionIndex + 1;
        int minOfMax = inflexionIndex + 1;
        while (start <= nums.length - 1) {
            if (nums[start] > nums[inflexionIndex]) {
                if (nums[minOfMax] > nums[start]) {
                    minOfMax = start;
                }
            }
            start++;
        }

        swapValue(nums, inflexionIndex, minOfMax);
        reverse(nums, inflexionIndex + 1, nums.length - 1);

        return nums;
    }

    private static void swapValue(int[] nums, int inflexionIndex, int minOfMax) {
        int temp = nums[minOfMax];
        nums[minOfMax] = nums[inflexionIndex];
        nums[inflexionIndex] = temp;
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
