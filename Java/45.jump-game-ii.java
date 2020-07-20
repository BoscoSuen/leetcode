/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    /*
    利用一个curMax记录当前能跳到的最远距离，在这个范围内都是一步，在curMax之内能到的，就都是一步能到，在边界外的，就需要在i遍历的范围时更新curMax来跳到最远边界。
    注意考虑边界到最后一个index时不用再加1了，所以只需要遍历到nums.length-1来找边界。
    time: O(n)
    space: O(1)
    */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int curMax = 0;
        int maxJump = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (i >= curMax) {
                count++;
                curMax = maxJump;
            }
        }
        return count;
    }
}
// @lc code=end

