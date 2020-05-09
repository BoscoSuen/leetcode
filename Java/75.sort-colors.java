/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    /*
    定义red指针指向开头位置，blue指针指向末尾位置, 遍历数组到blue指针位置，遇到0交换到最前面，
    当前位置和red指针+1；遇到2交换到最后面，blue指针-1；遇到1当前位置+1
    time: O(n)
    space: O(1)
    */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int red = 0, l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == 0) {
                swap(nums, red++, l++);
            } else if (nums[l] == 2) {
                swap(nums, r--,l);
            } else l++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

