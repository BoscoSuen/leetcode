/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 */

// @lc code=start
class Solution {
    /*
    值最多差t, 利用bucket sort, 将对应的值放到(t + 1)个bucket中，利用一个hashmap来存储对应的bucket的元素的值
    如果i > k时，删去i - k对应bucket的值
    对于求bucket的值，防止除出来的是负数，减去INT_MIN并转化为long
    time: O(n)
    space: O(t)
    */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k <= 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            long pos = ((long)nums[i] - Integer.MIN_VALUE) / ((long)t + 1);
            if (map.containsKey(pos) || 
                map.containsKey(pos - 1) && nums[i] - map.get(pos - 1) <= t || 
                map.containsKey(pos + 1) && map.get(pos + 1) - nums[i] <= t) {
                    return true;
            }
            if (i >= k && map.containsKey(((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1))) {
                map.remove(((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1));
            }
            map.put(pos, (long)nums[i]);
        }
        return false;
    }
}
// @lc code=end

