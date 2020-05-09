/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    /*
    lcs问题: dp[i][j] text1的前i个和text2的前j个的最长公共子序列
    如果当前字符相等,dp[i][j] = dp[i - 1][j - 1] + 1;
    否则dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    time: O(mn)
    space: O(mn)
    */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];     
        // dp[i][j]: longest subsequence in first i in text1 & first j in text2
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

