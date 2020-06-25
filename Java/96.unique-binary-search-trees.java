/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    /*
    https://paper.dropbox.com/doc/LC96-Unique-Binary-Search-Trees--A2gBtNTmVZj2KyEK9h_u~TAlAg-ogOcBtyp4ntiNWScrUUbq
    dp[i], i个元素组成的BST的个数, 对于某一个数i, 左边的元素个数为i - 1, 右边元素的个数为n - i, dp[i - 1] * dp[n - i]
    n = 3, 对于3个元素，可以是0是root: dp[0] * dp[2], 可以是1是root: dp[1] * dp[1], 可以是2是root: dp[2] * dp[0]  ==>
    dp[i] = sum(dp[j] * dp[i - 1 - j])
    time: O(n^2)
    space: O(n)
    */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
// @lc code=end

