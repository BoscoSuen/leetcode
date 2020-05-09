/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    /*
    同spiral matrix I, 利用rowBegin, rowEnd, colBegin, colEnd来记录当前遍历的范围进行循环遍历
    time: O(n^2)
    space: O(n^2)
    */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cur = 1;
        int rowBegin = 0, colBegin = 0;
        int rowEnd = n - 1, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; ++i) {
                res[rowBegin][i] = cur++;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; ++i) {
                res[i][colEnd] = cur++;
            }
            colEnd--;
            // 正方形矩阵不用考虑只用计算半边的情况
            for (int i = colEnd; i >= colBegin; --i) {
                res[rowEnd][i] = cur++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowBegin; --i) {
                res[i][colBegin] = cur++;
            }
            colBegin++;
        }
        return res;
    }
}
// @lc code=end

