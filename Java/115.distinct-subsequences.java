/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    /*
    DP dp[i][j] : t的(1,i)部分和s的(1,j)部分相等的subsequences数
    padding : dp[0][*] = 1 t为""，s中有一个subsequence""和之匹配
    if t[i] = s[j]  dp[i][j] = dp[i- 1][j - 1]  # t[i]和s[j]在subsequence中匹配
                            + dp[i][j - 1]      # s[j]不在subsequence中，和s(0, j-1)结果相同
    else            dp[i][j] = dp[i][j - 1]      # s多加一个j不会改变subsequences数
    */
    public int numDistinct(String s, String t) {
        // t.size() < s.size()
        int m = t.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

