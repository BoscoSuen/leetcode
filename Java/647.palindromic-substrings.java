/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    /*
    以字符串中的每一个字符都当作回文串中间的位置，然后向两边扩散，
    每当成功匹配两个左右两个字符，结果 count 自增1
    time: O(n^2)
    space: O(1)
    */
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); ++i) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return count;
    }
    
    private void extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++count;
            --left;
            ++right;
        }
    }
}
// @lc code=end

