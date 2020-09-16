/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) return 0;
        String[] strs = s.split(" ");
        return strs[strs.length - 1].length();
    }
}
// @lc code=end

