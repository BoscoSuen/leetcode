/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
class Solution {
    /*
    遇到的数字对应的index设置成负数，再碰到时加到res数组中
    time: O(n)
    space: O(1)
    */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int pos = Math.abs(nums[i]) - 1;
            if (nums[pos] < 0) {
                res.add(pos + 1);
            } else {
                nums[pos] = -nums[pos];
            }
        }
        return res;
    }
}
// @lc code=end

