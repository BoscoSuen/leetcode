/*
 * @lc app=leetcode id=1438 lang=java
 *
 * [1438] Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 */

// @lc code=start
class Solution {
    /*
    维护两个单调队列+sliding window
    time: O(n)
    space: O(n)
    */
    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) return 0;
        Deque<Integer> maxDq = new LinkedList<>();  // 递减队列
        Deque<Integer> minDq = new LinkedList<>();  // 递增队列
        int i = 0;
        int res = 0;
        for (int j = 0; j < nums.length; ++j) {
            while (!maxDq.isEmpty() && nums[j] > maxDq.peekLast()) { maxDq.pollLast(); }
            while (!minDq.isEmpty() && nums[j] < minDq.peekLast()) { minDq.pollLast(); }
            maxDq.add(nums[j]);
            minDq.add(nums[j]);
            if (maxDq.peekFirst() - minDq.peekFirst() > limit) {
                if (maxDq.peekFirst() == nums[i]) { maxDq.pollFirst(); }
                if (minDq.peekFirst() == nums[i]) { minDq.pollFirst(); }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
// @lc code=end

