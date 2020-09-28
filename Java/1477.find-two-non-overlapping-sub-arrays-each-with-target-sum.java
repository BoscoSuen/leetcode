/*
 * @lc app=leetcode id=1477 lang=java
 *
 * [1477] Find Two Non-overlapping Sub-arrays Each With Target Sum
 */

// @lc code=start
class Solution {
    /*
    建立prefix sum的map
    同时找sum - target 和sum + target
    time: O(n)
    space: O(n)
    */
    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        int leftMin = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                leftMin = Math.min(leftMin, i - map.get(sum - target));
            }
            if (map.containsKey(sum + target) && leftMin < Integer.MAX_VALUE) {
                res = Math.min(res, map.get(sum + target) - i + leftMin);
            }
        }
        return res == Integer.MAX_VALUE ? -1: res;
    }
}
// @lc code=end

