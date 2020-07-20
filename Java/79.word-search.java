/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0|| board[0] == null || board[0].length == 0) return false;
        // backtracking
        int rows = board.length;
        int cols = board[0].length;
        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[rows][cols];
        for (int y = 0; y < rows; ++y) {
            for (int x = 0; x < cols; ++x) {
                if (helper(x, y, visited, board, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(int x, int y, boolean[][] visited, char[][] board, char[] chars, int pos) {
        if (pos == chars.length) return true;
        if (x < 0 || y < 0 || x >= board[0].length || y >= board.length) return false;
        if (visited[y][x]) return false;
        if (board[y][x] != chars[pos]) return false;
        visited[y][x] = true;
        boolean result = 
           helper(x - 1, y, visited, board, chars, pos + 1) || 
           helper(x, y - 1, visited, board, chars, pos + 1) || 
           helper(x + 1, y, visited, board, chars, pos + 1) || 
           helper(x, y + 1, visited, board, chars, pos + 1);
        visited[y][x] = false;  // backtracking
        return result;
    }
}
// @lc code=end

