/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    /*
    n皇后问题：皇后之间互相攻击包括同行同列以及对角线
    dfs
    time: O(n*2 * n!) 
    space: O(n^2)
    */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(board[i], '.');
            }
        }
        dfs(board, res, 0);
        return res;
    }
    
    private void dfs(char[][] board, List<List<String>> res, int row) {
        if (row == board.length) {
            List<String> cur = new ArrayList<>();
            for (char[] line : board) {
                cur.add(new String(line));
            }
            res.add(cur);
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                dfs(board, res, row + 1);
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

