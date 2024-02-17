package org.example.graph.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFSInMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };
        BFSMatrix(grid, 0, 0);
    }

    public static void BFSMatrix(int[][] grid, int row, int col) {
        System.out.print(grid[row][col]);
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[row][col] = true;
        addNodeInQueueForTraversal(grid, row, queue, col);
        while (queue.size() != 0) {
            int[] nextIndex = queue.poll();
            if (visited[nextIndex[0]][nextIndex[1]] == false) {
                visited[nextIndex[0]][nextIndex[1]] = true;
                System.out.print(grid[nextIndex[0]][nextIndex[1]]+" ");
                addNodeInQueueForTraversal(grid, nextIndex[0], queue, nextIndex[1]);
            }
        }
    }

    private static void addNodeInQueueForTraversal(int[][] grid, int row, Queue<int[]> queue, int col) {
        //up
        if (row - 1 >= 0) {
            queue.add(new int[]{row - 1, col});
        }

        //right
        if (col + 1 <= grid[0].length - 1) {
            queue.add(new int[]{row, col + 1});
        }

        //down
        if (row + 1 <= grid.length - 1) {
            queue.add(new int[]{row + 1, col});
        }

        //left
        if (col - 1 >= 0) {
            queue.add(new int[]{row, col - 1});
        }
    }
}
