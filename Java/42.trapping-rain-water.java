/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    /*
    area += min(maxLeft, maxRight) - current height
    dp l[i], r[i]记录当前最大的l, r
    由于l[i], r[i] 为单调递增
    用maxL, maxR优化为two pointer
    time: O(n)
    space: O(1)
    */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        int res = 0;
        while (l < r) {
            if (maxL < maxR) {
                res += maxL - height[l];
                maxL = Math.max(maxL, height[++l]);
            } else {
                res += maxR - height[r];
                maxR = Math.max(maxR, height[--r]);
            }
        }
        return res;
    }
}
// @lc code=end

