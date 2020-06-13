/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    /*
    binary search [l,r), find first index than satisfy g(m)
    g(m): nums[idx] >= target
    */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
// @lc code=end

