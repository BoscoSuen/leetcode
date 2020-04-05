/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    /*
    用一个dp数组来记录以某个Index结尾的subarray的和，dp[i - 1]如果大于0的话，
    就将dp[i]记录为当前数字加上以i-1为结尾的subarray的和，如果小于，则开始找新的subarray，
    dp[i]设置为nums[i]
    ->
    由于dp[i - 1]之前的不再用到，所以用一个指针来代替原来的dp[i - 1](maxEndHere)
    */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxEndHere = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndHere = Math.max(maxEndHere + nums[i], nums[i]);
            max = Math.max(max, maxEndHere);
        }
        return max;
    }
}
// @lc code=end

