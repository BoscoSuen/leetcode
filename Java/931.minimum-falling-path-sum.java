/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    /*
    对于某一列只能从index+/-1的范围内取，直接把A作为dp数组，从上一列开始搜索
    time: O(mn)
    space: O(1)
    */
    public int minFallingPathSum(int[][] A) {
        int res = Integer.MAX_VALUE;
        int m = A.length, n = A[0].length;
        if (m == 1) {
            for (int j = 0; j < n; ++j) {
                res = Math.min(res, A[0][j]);
            }
            return res;
        }
        
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cur = A[i - 1][j];
                if (j > 0) cur = Math.min(cur, A[i - 1][j - 1]);
                if (j < n - 1) cur = Math.min(cur, A[i - 1][j + 1]);
                A[i][j] += cur;
                if (i == m - 1) res = Math.min(res, A[i][j]);
            }
        }
        return res;
    }
}
// @lc code=end

