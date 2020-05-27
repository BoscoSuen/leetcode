/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    /*
    同84题，扫描每一行，建立每一行的直方图，然后得到最大的面积
    time: O(mn) 建直方图和扫描都是O(mn)
    space: O(mn)
    */
    int max = 0;
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] hist = new int[m][n];
        buildHist(matrix, hist);
        for (int i = 0; i < m; ++i) {
            scan(hist, i);
        }
        return max;
    }

    private void buildHist(char[][] matrix, int[][] hist) {
        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[0][j] == '1') hist[0][j] = 1;
        }
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                hist[i][j] = matrix[i][j] == '1' ? hist[i - 1][j] + 1 : 0;
            }
        }
    }

    private void scan(int[][] hist, int row) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int j = 0; j <= hist[0].length; ++j) {
            int h = j == hist[0].length ? 0 : hist[row][j];
            while (stack.peek() != -1 && h < hist[row][stack.peek()]) {
                max = Math.max(max, hist[row][stack.pop()] * (j - stack.peek() - 1));
            }
            stack.push(j);
        }
    }
}
// @lc code=end

