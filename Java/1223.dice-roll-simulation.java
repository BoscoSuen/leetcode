/*
 * @lc app=leetcode id=1223 lang=java
 *
 * [1223] Dice Roll Simulation
 */

// @lc code=start
cclass Solution {
    /*
    dfs with memo
    dp[i][j][k] 第i次，最后一次扔出来的是j，连续了k次
    time: O(n * 6 * 6 * 15)
    space: O(n * 6 * 15)
    */
    int[][][] dp = new int[5001][7][16];
    int kMod = (int)1e9 + 7;
    public int dieSimulator(int n, int[] rollMax) {
        if (rollMax == null || rollMax.length == 0 || n == 0) return 0;
        return dfs(rollMax, n, -1, 0);
    }
    
    private int dfs(int[] rollMax, int n, int last, int count) {
        if (n == 0) return 1;
        if (last >= 0 && dp[n][last][count] > 0) return dp[n][last][count];
        int res = 0;
        for (int i = 0; i < 6; ++i) {
            if (i == last && count == rollMax[i]) continue;
            res = (res + dfs(rollMax, n - 1, i, i == last ? count + 1 : 1)) % kMod;
        }
        if (last >= 0) dp[n][last][count] = res;
        return res;
    }
}
// @lc code=end

