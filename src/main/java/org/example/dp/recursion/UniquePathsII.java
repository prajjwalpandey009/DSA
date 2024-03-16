package org.example.dp.recursion;

public class UniquePathsII {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return solveUniquePath(obstacleGrid, 0, 0);
    }

    private static int solveUniquePath(int[][] obstacleGrid, int right, int down) {
        if (down > obstacleGrid.length - 1 || right > obstacleGrid[0].length - 1) {
            return 0;
        }
        if (down == obstacleGrid.length - 1 && right == obstacleGrid[0].length - 1 && obstacleGrid[down][right] == 1) {
            return 1;
        } else if (obstacleGrid[down][right] == 1) {
            return 0;
        }
        int rightAns = solveUniquePath(obstacleGrid, right + 1, down);
        int downAns = solveUniquePath(obstacleGrid, right, down + 1);

        return rightAns + downAns;
    }
}
