/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    /*
    quick select 
    time: average O(n) worst O(n^2)
    space: O(1)
    */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index + 1 == k) return nums[index];
            else if (index + 1 > k) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return -1;
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;  // partition不包括pivot,最后加上
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);    // pivot放到r的位置， eg[1,2]和[2,1]
        return r;
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
// @lc code=end

