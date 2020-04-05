/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    /*
    dp: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    加padding并初始化dp[1][1] = 1,如果被占据，则dp[1][1] = 0
    被占据的地方dp值设为0，其余利用状态转移方程计算
    time: O(mn)
    space: O(mn)
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == 1 && j == 1) continue;
                if (obstacleGrid[i - 1][j - 1] == 1) dp[i][j] = 0;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }  
}
// @lc code=end

