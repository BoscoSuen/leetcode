/*
 * @lc app=leetcode id=818 lang=java
 *
 * [818] Race Car
 */

// @lc code=start
class Solution {
    /*
    dp: 子问题: 到某一个位置之后restart(掉头，速度重置)
    dp[t][d]: 从当前位置走到target并面向d(left = 0, right = 1)的最小action
    dp[t][d] = min(dp[i][0] + 2 + dp[t - i][d],     (2:掉头再掉头)
                   dp[i][1] + 1 + dp[t - i][d])
    time: O(n^2)
    space: O(n)
    */
    public int racecar(int target) {
        if (target == 0) return 0;
        int[][] dp = new int[target + 1][2];
        for (int t = 1; t <= target; ++t) {
            int n = (int)Math.ceil(Math.log(t + 1) / Math.log(2));
            if ((1 << n) == t + 1) {
                // 一直加速可以到
                dp[t][0] = n;
                dp[t][1] = n + 1;
                continue;
            }
            // 需要倒车
            int l = (1 << n) - 1 - t;
            dp[t][0] = n + 1 + Math.min(dp[l][1], dp[l][0] + 1);
            dp[t][1] = n + 1 + Math.min(dp[l][0], dp[l][1] + 1);
            // 遍历所有可能的restart
            for (int i = 1; i < t; ++i) {
                for (int d = 0; d <= 1; ++d) {
                    dp[t][d] = Math.min(dp[t][d], Math.min(
                        dp[i][0] + 2 + dp[t - i][d],
                        dp[i][1] + 1 + dp[t - i][d]));
                }
            }
        }
        return Math.min(dp[target][0], dp[target][1]);
    }
}
// @lc code=end

