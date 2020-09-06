/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    /*
    分第一家抢or not两种情况取dp最大值
    time: O(n)
    space: O(1)
    */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    
    private int helper(int[] nums, int start, int end) {
        int prevMax = 0, curMax = 0;
        for (int i = start; i <= end; ++i) {
            int temp = curMax;
            curMax = Math.max(curMax, prevMax + nums[i]);
            prevMax = temp;
        }
        return curMax;
    }
}
// @lc code=end

