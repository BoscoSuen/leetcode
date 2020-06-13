/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start

/*
'*':复制前一个字符或者把前一个字符删掉
dp[i][j]: if first i in s matchs first j in p
dp[j][0] = false s中只有a-z,不能match empty pattern
dp[0][j] = true 仅当p中全是*或者a*b*这种结构
dp[i][j] = 1. 当前字符match或者p是'.'  = dp[i-1][j-1]
           2. p当前是*:  = dp[i][j-2](*消除p的前一个字符) || （dp[i-1][j](*复制前一个字符) && ([i-1] == p[i - 2] || p[i - 2] == '.')
time: O(mn)
space: O(mn)
*/
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n; ++j) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = j > 1 && dp[0][j - 2];
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // p[j-1] == '*' means there is a previous char, i.e, j >= 2
                    dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

