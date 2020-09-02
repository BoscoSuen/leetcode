/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    /*
    考虑到有负数的情况，同时记录以当前数为结尾的subarray的最大乘积和最小乘积
    time: O(n)
    space:O(1)
    */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int tempMax = maxSoFar;
            maxSoFar = Math.max(Math.max(maxSoFar * nums[i], minSoFar * nums[i]), nums[i]);
            minSoFar = Math.min(Math.min(tempMax * nums[i], minSoFar * nums[i]), nums[i]);
            res = Math.max(res, maxSoFar);
        }
        return res;
    }
}
// @lc code=end

