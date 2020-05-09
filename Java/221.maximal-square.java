/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    /*
    dp[i][j]对应以(i,j)为右下角的正方形的最大的边长
    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
    1 1 1                 1 1 1                 1 1 1
    1 1 1 dp[i][j] = 3,   1 1 1 dp[i][j] = 2,   1 0 1 dp[i][j] = 1
    1 1 1                 0 1 1                 1 1 1
    time: O(n^2)
    space: O(n^2)
    */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
// @lc code=end

