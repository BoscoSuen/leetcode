/*
 * @lc app=leetcode id=688 lang=java
 *
 * [688] Knight Probability in Chessboard
 */

// @lc code=start
class Solution {
    /*
    对于每层dfs的概率，用0.125 * 下一层return的概率
    直接dfs会超时，需要用double[][][] dp = new double[N][N][K + 1]来记录当前位置走K步还在棋盘内的概率
    time: O(K * N^2) 解空间存在dp内
    space: O(K * N^2)
    */
    int[][] dirs = new int[][]{{-1, 2}, {-2, 1}, {1, 2}, {2, 1}, {-1, -2}, {-2, -1}, {2, -1}, {1, -2}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K + 1];
        return dfs(dp, N, K, r, c);
    }

    private double dfs(double[][][] dp, int N, int K, int r, int c) {
        if (!isValid(N, r, c)) {
            return 0;
        }
        if (K == 0) {
            return 1;
        }
        if (dp[r][c][K] != 0) return dp[r][c][K];
        double res = 0;
        for (int k = 0; k < dirs.length; ++k) {
            int nextR = r + dirs[k][0];
            int nextC = c + dirs[k][1];
            res += 0.125 * dfs(dp, N, K - 1, nextR, nextC);
        }
        dp[r][c][K] = res;
        return res;
    }

    private boolean isValid(int N, int i, int j) {
        return i >= 0 && j >= 0 && i < N && j < N;
    }
}
// @lc code=end

