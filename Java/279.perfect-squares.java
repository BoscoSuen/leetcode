/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    /*
    sub problem: 对于一个小的数i, 其对应的least perfect squares ==> dp[i]
    dp[i] = min(dp[i], dp[i - j^2] + 1)
    dp初始化 dp[1] = min(dp[1], dp[0] + 1), dp[0] = 0, 其余初始化成INT_MAX
    time: O(n^2)
    space: O(n)
    */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
// @lc code=end

