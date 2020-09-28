/*
 * @lc app=leetcode id=840 lang=java
 *
 * [840] Magic Squares In Grid
 */

// @lc code=start
class Solution {
    /*
    brute force
    time: O(mn)
    space: O(1)
    */
    public int numMagicSquaresInside(int[][] grid) {
        if (grid == null || grid.length < 3 || grid[0].length < 3) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m - 2; ++i) {
            for (int j = 0; j < n - 2; ++j) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isMagic(int[][] grid, int row, int col) {
        Set<Integer> set = new HashSet<>();
        for (int i = row; i < row + 3; ++i) {
            for (int j = col; j < col + 3; ++j) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || !set.add(grid[i][j])) {
                    return false;
                }
            }
        }
        int sum1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sum2 = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];
        if (sum1 != sum2) {
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != sum1) {
                return false;
            }
            if (grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != sum1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

