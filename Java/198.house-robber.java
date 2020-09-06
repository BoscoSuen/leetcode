/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    /*
    prevMax记录前一家没有抢的max, curMax记录当前家一定抢的max
    time: O(n)
    space: O(1)
    */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prevMax = 0, curMax = 0;
        for (int num : nums) {
            int temp = curMax;
            curMax = Math.max(curMax, prevMax + num);
            prevMax = temp;
        }
        return curMax;
    }
}
// @lc code=end

