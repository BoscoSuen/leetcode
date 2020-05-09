/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = nums[0];
        for (int num : nums) {
            if (count == 0) res = num;
            if (res == num) count++;
            else count--;
        }
        return res;
    }
}
// @lc code=end

