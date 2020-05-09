/*
 * @lc app=leetcode id=1007 lang=java
 *
 * [1007] Minimum Domino Rotations For Equal Row
 */

// @lc code=start
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int ra = 0, rb = 0;
        int i = 0;
        for (; i < A.length && (A[i] == A[0] || B[i] == A[0]); ++i) {
            if (A[i] != A[0]) ra++;
            else if (B[i] != A[0]) rb++;
        }
        if (i == A.length) return Math.min(ra, rb);
        ra = 0; rb = 0;
        for (i = 0; i < B.length && (A[i] == B[0] || B[i] == B[0]); ++i) {
            if (A[i] != B[0]) ra++;
            else if (B[i] != B[0])rb++;
        }
        if (i == B.length) return Math.min(ra, rb);
        return -1;
    }
}
// @lc code=end

