package org.example.array;

public class RotateArrayBy90Degree {
    public static void main(String[] args) {
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public static void rotate(int[][] matrix) {

        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = left;
                int down = right;
                //save top left
                int temp = matrix[top][left + i];

                //save bottom left into top left
                matrix[top][left + i] = matrix[down - i][left];

                //save bottom right into bottom left
                matrix[down - i][left] = matrix[down][right - i];

                //save top right into bottom right
                matrix[down][right - i] = matrix[top + i][right];

                //save top left into top right
                matrix[top + i][right] = temp;
            }
            left++;
            right--;
        }
    }
}
