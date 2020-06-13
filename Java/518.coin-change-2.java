/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
/*
完全背包问题
dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]], 只和i-1有关
优化空间复杂度:
dp[0...amount] 
    dp[j] += dp[j - coins[i - 1])
init: dp[0] = 1
time:O(n * amount)
space: O(amount)
*/
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j <= amount; ++j) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
// @lc code=end

