/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */

// @lc code=start
class Solution {
    /*
    dfs + memo, 储存当前的位置和跳的步数
    time: O(n^3)
    space: O(n^2)
    */
    public boolean canCross(int[] stones) {
        int[][] dp = new int[stones.length + 1][stones.length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return dfs(stones, dp, 0, 0) == 1;    // 0 makes first jump size 1
    }

    private int dfs(int[] stones, int[][] dp, int pos, int jump) {
        if (pos == stones.length - 1) return 1;
        if (dp[pos][jump] >= 0) return dp[pos][jump];
        for (int i = pos + 1; i < stones.length; ++i) {
            int d = stones[i] - stones[pos];
            if (d >= jump - 1 && d <= jump + 1) {
                if (dfs(stones, dp, i, d) == 1) {
                    dp[pos][jump] = 1;
                    return 1;
                }
            }
        }
        dp[pos][jump] = 0;
        return 0;
    }
}
// @lc code=end

