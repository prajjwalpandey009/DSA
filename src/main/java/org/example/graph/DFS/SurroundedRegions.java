package org.example.graph.DFS;

public class SurroundedRegions {

    public static void main(String[] args) {
        solve(new char[][]{
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
                {'O', 'X', 'O'}
        });
    }

    public static void solve(char[][] board) {
        boolean flag = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    solveDFS(board, i, j, visited);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println("hi");
    }

    private static void solveDFS(char[][] board, int i, int j, boolean[][] visited) {
        if (i + 1 >= board.length || i - 1 < 0 || j - 1 < 0 || j + 1 >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (board[i - 1][j] == 'X' || board[i - 1][j] == '0' &&
                board[i][j + 1] == 'X' || board[i][j + 1] == '0' &&
                board[i - 1][j] == 'X' || board[i - 1][j] == '0' &&
                board[i][j - 1] == 'X' || board[i][j - 1] == '0') {
            board[i][j] = 'X';
        }
        //up
        solveDFS(board, i - 1, j, visited);
        //right
        solveDFS(board, i, j + 1, visited);
        //down
        solveDFS(board, i + 1, j, visited);
        //left
        solveDFS(board, i, j - 1, visited);
    }
}
