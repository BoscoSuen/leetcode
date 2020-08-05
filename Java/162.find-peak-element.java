/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    /*
    由于边界也可以是peak,可以利用binary search找到一个max element
    mid <= mid + 1, left = mid + 1
    else right = mid, 找到最小的potential max element
    time: O(logn)
    space: O(1)
    */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] <= nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

