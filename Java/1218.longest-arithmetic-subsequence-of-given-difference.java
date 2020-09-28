/*
 * @lc app=leetcode id=1218 lang=java
 *
 * [1218] Longest Arithmetic Subsequence of Given Difference
 */

// @lc code=start
class Solution {
    /*
    记录以某个位置为结尾的subsequence length
    利用cur - diff的map key来查找count并更新
    time: O(n)
    space: O(n)
    */
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < arr.length; ++i) {
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            res = Math.max(res, map.get(arr[i]));
        }
        return res;
    }
}
// @lc code=end

