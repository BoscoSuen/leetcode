/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    /*
    * It is pretty hard to use the sliding window,
    * since the elements of the array are not all positives, making end increase 
    * doesn't mean the sum increase, and making start doesn't mean the sum decrease.
    time: O(n)
    space: O(n)
    */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) {
                res += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}
// @lc code=end

