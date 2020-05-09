/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    /*
    对于矩阵的旋转(顺时针or逆时针) 可以通过先按对角线翻转，再沿着某中轴进行翻转
    对于本题的顺时针操作，具体操作如下
    1 2 3        1 4 7          7 4 1
    4 5 6   ->   2 5 8     ->   8 5 2
    7 8 9        3 6 9          9 6 3
    */
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < i; ++j) {
                if (i == j) continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
// @lc code=end

