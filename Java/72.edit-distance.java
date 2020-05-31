/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    /*
    dp[i][j] = word1中前i个和word2中前j个的min distance
    eg: "aabc", "acc"
    last char相等 dp[i][j] = dp[i - 1][j - 1]
    "aab", "ac"
    dp[i][j] = 1 + min(dp[i - 1][j],    //delete b
                        dp[i][j - 1],   // insert c
                        dp[i - 1][j - 1]) // replace b to c
    "a", "", dp[i][j] = len(word1) = i;
    time: O(mn)
    space: O(mn)
    */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; ++j) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

