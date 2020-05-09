/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    /*
    规律：从后往前，碰到的第一组上升的pair(nums[i] < nums[i + 1])，
    将nums[i]和从后往前碰到的第一个比nums[i]大的元素进行调换，
    然后将i之后的数组部分进行翻转(因为其是降序的)
    eg: 1 2 7 4 3 1
    ->  1 3 7 4 2 1
    ->  1 3 1 2 4 7
    如果没有此nums[i]，则将整个数组进行翻转
    time: O(n)
    space: O(1)
    */
    public void nextPermutation(int[] nums) {
        int left = -1, right = -1;
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i] > nums[i - 1]) {
                left = i - 1;
                break;
            }
        }
        if (left == -1) {
            swap(nums,0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i > left; --i) {
            if (nums[i] > nums[left]) {
                right = i;
                break;
            }
        }
        swapHelper(nums,left, right);
        swap(nums,left + 1, nums.length - 1);
    }

    private void swap(int[] nums, int left, int right) {
        while (left < right) {
            swapHelper(nums, left++, right--);
        }
    }

    private void swapHelper(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
// @lc code=end
