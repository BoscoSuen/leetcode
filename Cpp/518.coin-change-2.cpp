/*
 * @lc app=leetcode id=518 lang=cpp
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
/*
完全背包问题
dp[i][j]: 前i种coin组成value j的所有可能数
dp[i][j] = dp[i - 1][j](coins[i-1]不选) + dp[i][j - coins[i - 1]](coins[i-1]至少使用一个)
time: O(n * amount)
space: O(n * amount)
*/
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>> dp(coins.size() + 1, vector<int>(amount + 1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= coins.size(); ++i) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; ++j) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.size()][amount];
    }
};
// @lc code=end

