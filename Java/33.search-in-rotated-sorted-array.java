/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    /*
    binary search, 其中一边是rotated,一边是sorted
    https://paper.dropbox.com/doc/LC33-Search-in-Rotated-Sorted-Array--AxH3mDOCIXBcjx02h_NG6q0RAg-FP9pY9sOnnnKSoEHdnGUi
    左闭右开，找到最小的m使得[l,m)区间内g(m)一定为true(此题内的g(m)为有target的数)
    分为两种情况:
        0.  找到target, 停止binary search
        1.  nums[mid] < nums[left], 左边一定是rotated, eg: 6 7 1 2 3 4 5
            如果target > nums[left] or target < nums[mid], 就一定在左半边
        2.  nums[mid] >= nums[left], 左边一定是sorted, eg: 3 4 5 6 7 1 2
            如果nums[left] <= target < nums[mid], 就一定在左边
    从此可以找到满足g(m)的条件
    * 注意 [1,3], [3,1]这种corner case
    time: O(logn)
    space: O(1)
    */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            if ((nums[mid] < nums[left] && (target >= nums[left] || target < nums[mid])) || (nums[mid] >= nums[left] && (target >= nums[left] && target < nums[mid]))) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

