/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    /*
    dfs + backtracking
    time: O((9 * 9)^(number of '.')) (not sure)
    space: O(number of '.')
    */
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if (i == board.length) return true;
        if (j == board[0].length) return solve(board, i + 1, 0);
        for (char c = '1'; c <= '9'; ++c) {
            if (board[i][j] != '.') return solve(board, i, j + 1);
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (solve(board, i, j + 1)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char c ) {
        for (int k = 0; k < 9; ++k) {
            if (board[i][k] == c || board[k][j] == c ||
                board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c) {
                    return false;
            }
        }
        return true;
    }
}
// @lc code=end

