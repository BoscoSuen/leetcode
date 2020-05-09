/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int pos = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }
}
// @lc code=end

