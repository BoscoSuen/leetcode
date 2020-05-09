/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    track当前遍历的row,col范围
    注意：半边之后要重新判断防止重复遍历，eg: [3 1],只需要遍历半边就可以了
    time: O(mn)
    space: O(mn)
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int rowBegin = 0, colBegin = 0;
        int rowEnd = m - 1, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; ++i) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; ++i) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i>= colBegin; --i) {
                    res.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i>= rowBegin; --i) {
                    res.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }
        return res;
    }
}
// @lc code=end

