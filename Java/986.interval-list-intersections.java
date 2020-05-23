/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    /*
    time: O(m+n)
    space: O(n)
    */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int m = A.length, n = B.length;
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A[i][1] < B[j][0]) ++i;
            else if (B[j][1] < A[i][0]) ++j;
            else {
                int start = Math.max(A[i][0], B[j][0]);
                int end = Math.min(A[i][1], B[j][1]);
                if (start <= end) res.add(new int[]{start, end});
                if (A[i][1] < B[j][1]) {
                    // compare the end instead of start
                    // ------  ----
                    //  -- - -----
                    // if we compare the start, we may miss some intersections
                    i++;
                } else {
                    j++;
                }
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
// @lc code=end

