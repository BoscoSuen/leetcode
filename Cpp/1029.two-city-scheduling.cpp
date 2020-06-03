/*
 * @lc app=leetcode id=1029 lang=cpp
 *
 * [1029] Two City Scheduling
 */

// @lc code=start
class Solution {
/*
dp[i][j]: 前i个人中，有j个人在A的最小cost
dp[i][j] = min(dp[i - 1][j - 1] + costs[i - 1][0], dp[i - 1][j] + costs[i - 1][1])
注意初始化dp[i][0]为dp[i - 1][0] + costs[i - 1][1]
dp[0][0] = 0
time: O(n^2)
space: O(n^2)
*/
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        int n = costs.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, INT_MAX / 2)); // INT_MAX will out of boundary
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][1];
            for (int j = 1; j <= i; ++j) {
                dp[i][j] = min(dp[i - 1][j - 1] + costs[i - 1][0],
                               dp[i - 1][j] + costs[i - 1][1]);
            }
        }
        return dp[n][n / 2];
    }
};
// @lc code=end

