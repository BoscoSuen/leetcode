/*
 * @lc app=leetcode id=1312 lang=java
 *
 * [1312] Minimum Insertion Steps to Make a String Palindrome
 */

// @lc code=start
class Solution {
    /*
    区间dp, 从小区间开始dp
    dp[i][j]: [i,j]范围内构成palindrome最小插入的字符数
    dp[i][j] = s[i] == s[j] ? dp[i+1][j-1] : min(dp[i+1][j],d[i][j-1]) + 1
    time: O(n^2)
    space: O(n^2)
    */
    public int minInsertions(String s) {
        if (s == null || s.length() < 2) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int size = 2; size <= n; ++size) {
            for (int i = 0, j = size - 1; j < n; ++i, ++j) {
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] : Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[0][n - 1];
    }
}
// @lc code=end

