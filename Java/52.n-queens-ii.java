/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    /*
    思路同lc51
    */
    int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(board[i], '.');
            }
        }
        dfs(board, 0);
        return count;
    }

    private void dfs(char[][] board, int row) {
        if (row == board.length) {
            count++;
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                dfs(board, row + 1);
                board[row][i] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int r, int c) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board.length; ++j) {
                if (board[i][j] == 'Q' && (i == r || c == j || r + c == i + j || r + j == i + c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

