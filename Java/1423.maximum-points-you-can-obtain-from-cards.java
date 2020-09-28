/*
 * @lc app=leetcode id=1423 lang=java
 *
 * [1423] Maximum Points You Can Obtain from Cards
 */

// @lc code=start
class Solution {
    /*
    find min subarray with length n - k
    time: O(n)
    space: O(1)
    */
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length == 0) return 0;
        int n = cardPoints.length;
        int total = 0;
        int cur = 0;
        int min = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < n; ++r) {
            total += cardPoints[r];
            cur += cardPoints[r];
            if (r - l + 1 == (n - k)) {
                min = Math.min(min, cur);
                cur -= cardPoints[l++];
            }
        }
        return min == Integer.MAX_VALUE ? total : total - min;  
    }
}
// @lc code=end

