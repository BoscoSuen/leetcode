/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    /*
    dfs+memo
    subproblem: 从某一位置开始的最长increasing path
    time: O(mn)
    space: O(mn)
    */
    int m;
    int n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(memo[i], -1);
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, dfs(matrix, memo, i, j));
            }
        }
        return res;
    }
    
    private int dfs(int[][] matrix, int[][] memo, int r, int c) {
        if (memo[r][c] != -1) return memo[r][c];
        int res = 1;    // 如果这是最大位置，longest path = 1
        int[] dirs = new int[]{1, 0, -1, 0, 1};
        for (int i = 0; i < 4; ++i) {
            int nextR = r + dirs[i];
            int nextC = c + dirs[i + 1];
            if (nextR >= 0 && nextC >= 0 && nextR < m && nextC < n && matrix[nextR][nextC] > matrix[r][c]) {
                res = Math.max(res, 1 + dfs(matrix, memo, nextR, nextC));
            }
        }
        memo[r][c] = res;
        return res;
    }
}
// @lc code=end

