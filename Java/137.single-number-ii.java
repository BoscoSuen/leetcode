/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    /*
    利用位操作 Bit Manipulation 来解。可以建立一个 32 位的数字，来统计每一位上1出现的个数，如果某一位上为1的话，
    那么如果该整数出现了三次，对3取余为0，这样把每个数的对应位都加起来对3取余，最终剩下来的那个数就是单独的数字
    time: O(n)
    space: O(1)
    */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int j = 0; j < nums.length; ++j) {
                sum += (nums[j] >> i) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
    }
}
// @lc code=end

