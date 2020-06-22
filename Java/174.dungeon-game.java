/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    /*
    只能向右或向下, 暗示dp
    从又下到左上dp, 初始化成INT_MAX, 右下角右边和下面加1的padding
    P 1
    1 INT_MAX
    dp[i][j] = max(1, min(dp[i+1][j], dp[i][j +1]) - dungeon[i][j])
    time: O(mn)
    space: O(mn)
    */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                dp[i][j] = Math.max(1, (Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]));
            }
        }
        return dp[0][0];
    }
    
}
// @lc code=end

