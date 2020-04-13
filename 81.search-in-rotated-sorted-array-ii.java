/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
/*
对于有重复的case, 需要多一次判断找不到哪边是rotated or sorted(mid = left = right), 只需要将两边指针一起移动就可
corner case: [3,1], target 3
time:O(logn)
space: O(1)
*/
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[left] && nums[mid] == nums[right - 1]) {
                ++left;
                --right;
            } else if ((nums[mid] < nums[left] && (nums[mid] > target || nums[left] <= target)) || (nums[mid] >= nums[left] && nums[mid] > target && target >= nums[left])) {
                right = mid;
            } else left = mid + 1;
        }
        return false;
    }
}
// @lc code=end

