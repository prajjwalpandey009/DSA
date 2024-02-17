package org.example.binarysearch;

//https://leetcode.com/problems/search-a-2d-matrix/
//Search a 2D Matrix II
//Algorithm
//Find that potential row
//Find that letter exists or not
public class ApplyBinarySearchOnGrid {
    public static void main(String[] args) {
        int[][] grid =
                {
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                };

        searchMatrix(grid, 3);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean isExist = false;
        int potentialRow = findRowInWhichElementMayLie(matrix, target);
        if (potentialRow == -1) {
            return false;
        }
        isExist = checkElementInARow(matrix, target, potentialRow);
        return isExist;

    }

    private static boolean checkElementInARow(int[][] matrix, int target, int potentialRow) {
        int low = 0;
        int high = matrix[0].length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == matrix[potentialRow][mid]) {
                return true;
            } else if (target <= matrix[potentialRow][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    private static int findRowInWhichElementMayLie(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;


        int start = 0;
        int end = matrix[0].length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target >= matrix[mid][start] && target <= matrix[mid][end]) {
                return mid;
            } else if (target <= matrix[mid][start]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
