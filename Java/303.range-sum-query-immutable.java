/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {
    /*
    prefix sum
    */
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) return nums[j];
        return nums[j] - nums[i - 1];
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

