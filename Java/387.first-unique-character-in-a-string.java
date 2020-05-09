/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }
        for (int i = 0; i < s.length(); ++i) {
            if (count[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
// @lc code=end

