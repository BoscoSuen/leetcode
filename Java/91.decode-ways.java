/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    /*
    计数暗示dp
    dfs with memo
    sub problem: 从某一index开始的decode ways
    time: O(n)
    space: O(n)
    */
    int count = 0;
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        return dfs(s, dp, 0);
    }

    private int dfs(String s, Map<Integer, Integer> dp, int pos) {
        if (pos == s.length()) return 1;
        if (dp.containsKey(pos)) return dp.get(pos);
        if (s.charAt(pos) == '0') return 0;
        int res = 0;
        res += dfs(s, dp, pos + 1);
        if (pos < s.length() - 1 && Integer.parseInt(s.substring(pos, pos + 2)) <= 26) {
            res += dfs(s, dp, pos + 2);
        }
        dp.put(pos, res);
        return res;
    }
}
// @lc code=end

