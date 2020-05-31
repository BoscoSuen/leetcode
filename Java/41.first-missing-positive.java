/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    /*
    bucket sort
    [3,4,-1,1]     input
    [0,1,2,3]     index
    [1,-1,3,4]     bucket sort,数组元素到对应位置index + 1，并和原数字替换
    之后遍历数组找不同的数，输出对应index+1
    考虑超出index范围的数 eg. [1,99,3,4] 99不考虑
    time: O(n)
    space: O(1)
    */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
// @lc code=end

