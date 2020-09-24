/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    /*
    binary search找到最小的满足条件的element, 最后结果一定是数组里的数
    time: O(mnlog(max - min))
    space: O(1)
    */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int left = matrix[0][0], right = matrix[m - 1][n - 1] + 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int count = 0;
            for (int i = 0; i < m; ++i) {
                int j = n - 1;
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += j + 1;
            }
            if (count < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
// @lc code=end

