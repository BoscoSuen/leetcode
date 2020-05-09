/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    /*
    最终的结果都是要乘到结果res中，所以我们可以不用单独的数组来保存乘积，
    而是直接累积到res中，我们先从前面遍历一遍，将乘积的累积存入res中，
    即每个位置左边的所有数的乘积，然后从后面开始遍历，用到一个临时变量right，
    初始化为1，然后每次不断累积该位置右边的所有数的乘积
    time: O(n)
    extra space: O(1)
    */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
// @lc code=end

