/*
 * @lc app=leetcode id=1155 lang=java
 *
 * [1155] Number of Dice Rolls With Target Sum
 */

// @lc code=start
class Solution {
    /*
    dfs会超时, dfs+memo
    time: O(d * f * target)
    space: O(d * f)
    */
    public int numRollsToTarget(int d, int f, int target) {
        int[][] memo = new int[d + 1][target + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dfs(d, f, target, memo);
    }
    
    private int dfs(int d, int f, int target, int[][] memo) {
        if (d == 0 || target <= 0) {
            return d == 0 && target == 0 ? 1 : 0;
        }
        if (memo[d][target] != -1) return memo[d][target];
        int res = 0;
        for (int i = 1; i <= f; ++i) {
            res += dfs(d - 1, f, target - i, memo);
            res %= 1000000007;
        }
        memo[d][target] = res;
        return res;
    }
}
// @lc code=end

