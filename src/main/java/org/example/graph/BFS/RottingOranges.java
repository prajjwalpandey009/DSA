package org.example.graph.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

//        int[][] grid = {
//                {2, 1, 1},
//                {1, 1, 1},
//                {0, 1, 2}
//        };
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (grid[i][j] == 2) {
                    return callBFS(grid, i, j, visited, queue);
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j] == false) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }

    private static int callBFS(int[][] grid, int row, int col, boolean[][] visited, Queue<int[]> queue) {
        addIndexInQueue(grid, row, col, queue, 0);
        visited[row][col] = true;
        int maxDepth = 0;

        while (queue.size() != 0) {
            int[] nextRowColArray = queue.poll();
            int nextRow = nextRowColArray[0];
            int nextCol = nextRowColArray[1];
            int depth = nextRowColArray[2];
            if (grid[nextRow][nextCol] == 0 || grid[nextRow][nextCol] == 2) {
                continue;
            }
            if (visited[nextRow][nextCol] == false) {
                maxDepth = Math.max(depth, maxDepth);
                visited[nextRow][nextCol] = true;
                addIndexInQueue(grid, nextRow, nextCol, queue, grid[nextRow][nextCol] == 2 ? depth : depth + 1);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j] == false) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
        }
        return maxDepth;
    }

    private static void addIndexInQueue(int[][] grid, int row, int col, Queue<int[]> queue, int depth) {
        //up
        if (row - 1 >= 0) {
            queue.add(new int[]{row - 1, col, depth});
        }
        //right
        if (col + 1 <= grid[0].length - 1) {
            queue.add(new int[]{row, col + 1, depth});
        }

        //down
        if (row + 1 <= grid.length - 1) {
            queue.add(new int[]{row + 1, col, depth});
        }

        //left
        if (col - 1 >= 0) {
            queue.add(new int[]{row, col - 1, depth});
        }
    }
}
