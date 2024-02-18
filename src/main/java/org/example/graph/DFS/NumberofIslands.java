package org.example.graph.DFS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class NumberofIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] point = new int[]{0, 0};
        return BFS(grid, visited, point);
    }

    public static int BFS(char[][] grid, boolean[][] visited, int[] point) {
        int count = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(point);

        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            int row = index[0];
            int col = index[1];
            if (visited[row][col]) {
                continue;
            }
            if (grid[row][col] == '1') {
                count++;
                DFS(grid, visited, new int[]{row, col}, queue);
            }

            visited[row][col] = true;

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

        return count;

    }

    private static void DFS(char[][] grid, boolean[][] visited, int[] points, Queue<int[]> queue) {
        Stack<int[]> stack = new Stack<>();
        stack.push(points);

        while (!stack.isEmpty()) {
            int[] point = stack.pop();
            int row = point[0];
            int col = point[1];

            if (grid[row][col] == '0' || visited[row][col] == true) {
                queue.add(new int[]{row, col});
                continue;
            }

            visited[row][col] = true;
            //up
            if (row - 1 >= 0) {
                stack.push(new int[]{row - 1, col});
            }

            //right
            if (col + 1 <= grid[0].length - 1) {
                stack.push(new int[]{row, col + 1});
            }


            //down
            if (row + 1 <= grid.length - 1) {
                stack.push(new int[]{row + 1, col});
            }


            //left
            if (col - 1 >= 0) {
                stack.push(new int[]{row, col - 1});
            }

        }
    }
}
