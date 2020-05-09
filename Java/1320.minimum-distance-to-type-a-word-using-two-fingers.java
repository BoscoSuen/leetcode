/*
 * @lc app=leetcode id=1320 lang=java
 *
 * [1320] Minimum Distance to Type a Word Using Two Fingers
 */

// @lc code=start
class Solution {
    /*
    dp: top2bot dfs with memorization
    dp[n][i][j] 从word的index n开始，左手在字母index为i的键位上(默认为26)(eg: 手指在B就是1), 右手在index为j的键位上
    dp = min(distance(i, word at n+1) + dfs, distance(j, word at n+1) + dfs)
    time: O(n*27^2)
    space: O(n*27^2)
    */
    public int minimumDistance(String word) {
        if (word == null || word.length() == 0) return 0;
        int[][][] dp = new int[word.length()][27][27];
        for (int[][] arrs : dp) {
            for (int[] arr : arrs) Arrays.fill(arr, -1);
        }
        return dfs(word, dp, 0, 26, 26);
    }
    
    private int dfs(String word, int[][][] dp, int pos, int left, int right) {
        if (pos == word.length()) return 0;
        if (dp[pos][left][right] != -1) return dp[pos][left][right];
        int nextIdx = word.charAt(pos) - 'A';
        dp[pos][left][right] =  Math.min(dis(left, nextIdx) + dfs(word, dp, pos + 1, nextIdx, right), dis(right, nextIdx) + dfs(word, dp, pos + 1, left, nextIdx));
        return dp[pos][left][right];
    }
    
    private int dis(int i, int j) {
        if (i == 26 || j == 26) return 0;
        return Math.abs(i / 6 - j / 6) + Math.abs(i % 6 - j % 6);
    }
}
// @lc code=end