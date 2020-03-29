/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    /*
    左闭右开
    下界g(m): g(m) >= target
    上界g(m): g(m) > target, 得到的满足条件的最小m需要减1
    time: O(logn)
    space: O(1)
    */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        return new int[]{findLowerBound(nums, target), findUpperBound(nums, target)};
    }

    private int findLowerBound(int[] nums, int target) {
        // find the lowest index that nums[index] >= target
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return (left < nums.length && nums[left] == target) ? left : -1;
    }

    private int findUpperBound(int[] nums, int target) {
        // find the lowest index that nums[index] > target,
        // so the upper bound should be index - 1
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) right = mid;
            else left = mid + 1;
        }
        return (left > 0 && nums[left - 1] == target) ? left - 1 : -1;
    }
}
// @lc code=end

