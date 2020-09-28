/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
    /*
    单调栈，找到左边的比其大的范围和右边比其大的范围
    https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/C%2B%2BJavaPython-Stack-Solution
    time: O(n)
    space: O(n)
    */
    public int sumSubarrayMins(int[] A) {
        if (A == null || A.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0, mod = (int)1e9 + 7;
        for (int i = 0; i <= A.length; ++i) {
            int cur = i == A.length ? 0 : A[i];
            while (!stack.isEmpty() && cur < A[stack.peek()]) {
                int pos = stack.pop();
                int left = pos - (stack.isEmpty() ? -1 : stack.peek());
                int right = i - pos;
                res = (res + A[pos] * left * right) % mod;
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

