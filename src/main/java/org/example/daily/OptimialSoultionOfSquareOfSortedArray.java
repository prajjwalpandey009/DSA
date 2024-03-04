package org.example.daily;

public class OptimialSoultionOfSquareOfSortedArray {
    public static void main(String[] args) {
        sortedSquares(new int[]{-7, -3, 2, 3, 11});
    }

    public static int[] sortedSquares(int[] nums) {
        int[] merged = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int index = nums.length - 1;
        while (i <= j) {
            int prefixSquare = nums[i] * nums[i];
            int suffixSquare = nums[j] * nums[j];
            if (prefixSquare < suffixSquare) {
                merged[index] = suffixSquare;
                j--;
            } else {
                merged[index] = prefixSquare;
                i++;
            }
            index--;
        }
        return merged;
    }
}
