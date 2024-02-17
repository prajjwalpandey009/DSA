package org.example.graph.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

//Time waste Question:-
//https://leetcode.com/problems/shortest-bridge/description/

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };

//        int[][] grid = {
//                {0, 1},
//                {1, 0}
//        };

        System.out.println(shortestBridge(grid));
    }

    public static int shortestBridge(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        int row = grid.length;
        int col = grid[0].length;
        boolean exitflag = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    callDFS(queue, grid, i, j);
                    exitflag = true;
                    break;
                }
            }
            if (exitflag) {
                break;
            }
        }

        while (queue.size() != 0) {
            int[] nextIndex = queue.poll();
            int nextRow = nextIndex[0];
            int nextCol = nextIndex[1];
            int depth = nextIndex[2];
            if (grid[nextRow][nextCol] == 1) {
                return depth;
            }
            grid[nextRow][nextCol] = 3;
            addNodeInQueueForTraversal(grid, nextRow, queue, nextCol, grid[nextRow][nextCol] == 3 ? depth + 1 : 0);
        }

        return 0;
    }

    private static void callDFS(Queue<int[]> queue, int[][] grid, int row, int col) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == 0 || grid[row][col] == 2) {
            return;
        }

        grid[row][col] = 2;
        queue.add(new int[]{row, col, 0});

        //up
        callDFS(queue, grid, row - 1, col);

        //right
        callDFS(queue, grid, row, col + 1);

        //down
        callDFS(queue, grid, row + 1, col);

        //left
        callDFS(queue, grid, row, col - 1);
    }

    private static void addNodeInQueueForTraversal(int[][] grid, int row, Queue<int[]> queue, int col, int depth) {
        //up
        if (row - 1 >= 0 && grid[row - 1][col] != 3) {
            queue.add(new int[]{row - 1, col, depth});
        }

        //right
        if (col + 1 <= grid[0].length - 1 && grid[row][col + 1] != 3) {
            queue.add(new int[]{row, col + 1, depth});
        }

        //down
        if (row + 1 <= grid.length - 1 && grid[row + 1][col] != 3) {
            queue.add(new int[]{row + 1, col, depth});
        }

        //left
        if (col - 1 >= 0 && grid[row][col - 1] != 3) {
            queue.add(new int[]{row, col - 1, depth});
        }
    }
}
