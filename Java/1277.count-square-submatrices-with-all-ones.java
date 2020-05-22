/*
 * @lc app=leetcode id=1277 lang=java
 *
 * [1277] Count Square Submatrices with All Ones
 */

// @lc code=start
class Solution {
    /*
    dp, 思路同求最大正方形面积
    time: O(mn)
    space: O(mn)
    */
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (matrix[i - 1][j - 1] == 0) dp[i][j] = 0;
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                res += dp[i][j];
            }
        }
        return res;
    }
}
// @lc code=end

