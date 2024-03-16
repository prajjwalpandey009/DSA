package org.example.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraversal {
    public static void main(String[] args) {
        spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int dir = 0;

        while (top <= down && left <= right) {

            if (dir == 0) {
                //Travel left to right
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
            }

            if (dir == 1) {
                //Travel top to down
                for (int i = top; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
            }

            if (dir == 2) {
                //Travel right to left
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
                down--;
            }

            if (dir == 3) {
                //Travel down to up
                for (int i = down; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }

            dir++;

            if (dir == 4) {
                dir = 0;
            }

        }

        return ans;
    }
}
