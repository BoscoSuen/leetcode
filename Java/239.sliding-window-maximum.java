/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    /*
    Monotonic queue:
    维护一个单调队列，储存potential max值，即max及可能是后面sliding window的max的元素对应的Index
    如果出现一个更大的值就把前面的全删掉
    如果sliding window左边界的位置大于等于了first indice,则这个最大值之后不会再用上了，将其删除
    time: averageO(n)
    space: O(k)
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(i);
            if (i - k + 1 >= 0) res[i - k + 1] = nums[q.peekFirst()];
            if (i - k + 1 >= q.peekFirst()) q.pollFirst(); // =时，下一个i就不能用了，remove
        }
        return res;
    }
}
// @lc code=end

