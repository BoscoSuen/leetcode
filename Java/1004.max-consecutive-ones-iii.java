/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    /*
    sliding window
    time: O(n)
    space: O(1)
    */
    public int longestOnes(int[] A, int K) {
        int res = 0;
        int i = 0, j = 0;
        for (; j < A.length; ++j) {
            if (A[j] == 0) K--;
            while (K < 0) {
                if (A[i++] == 0) K++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
// @lc code=end

