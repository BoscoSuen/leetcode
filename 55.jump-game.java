/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    /*
    greedy
    track当前能跳到的最远距离maxReach, 并用index + nums[index]更新最远距离
    如果遍历的某个index > maxReach，则无法跳到
    time: O(n)
    space: O(1)
    */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int maxReach = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
// @lc code=end

