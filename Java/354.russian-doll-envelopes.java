/*
 * @lc app=leetcode id=354 lang=java
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start
class Solution {
    /*
    先讲数组按照第一个元素排列，然后从第二个元素序列中找到最长的递增子序列
    * 找到最长的递增子序列，leetcode 300: https://leetcode.com/problems/longest-increasing-subsequence/
    注意, [3,4]不能把[3,3]包进去，所以排序的时候[3,3]要在[3,4]的后面
    还要注意[[1,1],[1,1],[1,1]]的情况, 所以二分的边界条件为g(m): >= envelopes[i][1]
    time: O(nlogn)
    space: O(n)
    */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? (b[1] - a[1]) : a[0] - b[0]));
        int[] tails = new int[envelopes.length];
        int res = 0;
        for (int i = 0; i < envelopes.length; ++i) {
            int left = 0, right = res;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (tails[mid] >= envelopes[i][1]) {
                    right = mid;
                } else left = mid + 1;
            }
            tails[left] = envelopes[i][1];
            if (left == res) res++;
        }
        return res;
    }
}
// @lc code=end

