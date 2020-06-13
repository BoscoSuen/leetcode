/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    /*
    用l,r指针记录0和2的位置，用cur指针遍历数组，碰到0就和l位置的交换，碰到2就和r位置的交换
    注意: 和r位置交换之后可能还需要交换,cur指针不变
    遍历条件: cur <= right, cur==right时当前数字还没有判断，需要遍历
    time: O(n)
    space: O(1)
    */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, right = nums.length - 1, cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, cur++, left++);
            } else if (nums[cur] == 2) {
                swap(nums, cur, right--);
            } else cur++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

