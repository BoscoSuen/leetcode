/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */

// @lc code=start
class Solution {
    /*
    思路同leetcode325,利用一个hashmap来存储到index i位置的子数组的和，对应value为此部分和对应的结尾Index，利用sum来累加从index 0 到当前位置的数字的和
    如果sum(current) - sum(i) = k,则可以找到一组和为k的子序即对于当前的sum, 判断map.containsKey(sum - k)，如果有，则这部分的subarray的长度为 i - map.get(i - sum)
    本题中将0置为-1,找到sum = 0的subarray即可
    time: O(n)
    space: O(n)
    */
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; ++i) {
            if(nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum == 0) {
                res = Math.max(res, i + 1);
            } else if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            }
            if (!map.containsKey(sum)) map.put(sum, i); // 多个相同sum不考虑，第一个出现的sum的位置一定对应最远的位置
        }
        return res;
    }
}
// @lc code=end

