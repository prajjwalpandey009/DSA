package org.example.graph.DFS;

public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    return startDFS(row, col, grid);
                }
            }
        }
        return 0;
    }

    private static int startDFS(int row, int col, int[][] grid) {
        int perimeter = 0;

        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == 0) {
            return 1;
        }
        if (grid[row][col] == 2) {
            return 0;
        }

        grid[row][col] = 2;
        //up
        perimeter += startDFS(row - 1, col, grid);

        //right
        perimeter += startDFS(row, col + 1, grid);


        //down
        perimeter += startDFS(row + 1, col, grid);


        //left
        perimeter += startDFS(row, col - 1, grid);

        return perimeter;
    }
}
