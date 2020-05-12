/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {
    /*
    mid index odd
    1 1 x 2 2 3 3 mid = mid + 1 -> {1 1 x}
    1 1 2 2 x 3 3 mid = mid - 1 -> {x 3 3}
    mid index even
    1 1 x 2 2 3 3 4 4 mid = mid - 1 -> {1 1 x}
    1 1 2 2 3 3 x 4 4 mid = mid + 1 -> {x 4 4}
    corner case:
    1 1 x -> right -> r = mid + 1 -> {x} left = right -> return nums[left] 
    time: O(logn)
    space: O(1)
    */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (mid > 0 && nums[mid - 1] == nums[mid] || mid + 1 < n && nums[mid + 1] == nums[mid]) {
                if (mid % 2 != 0) {
                    if (nums[mid] == nums[mid + 1]) right = mid - 1;
                    else if (nums[mid] == nums[mid - 1]) left = mid + 1;
                } else {
                    if (nums[mid] == nums[mid - 1]) right = mid - 2;
                    else if (nums[mid] == nums[mid + 1]) left = mid + 2;
                }
            } else return nums[mid];
        }
        return nums[left];
    }
}
// @lc code=end

