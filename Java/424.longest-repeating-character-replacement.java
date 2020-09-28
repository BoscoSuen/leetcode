/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    /*
    如果没有k的限制，让我们求把字符串变成只有一个字符重复的字符串需要的最小置换次数，那么就是字符串的总长度减去出现次数最多的字符的个数。
    如果加上k的限制，我们其实就是求满足 (子字符串的长度减去出现次数最多的字符个数)<=k 的最大子字符串长度即可
    */
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int[] count = new int[26];
        int maxCount = 0;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            maxCount = Math.max(maxCount, ++count[s.charAt(j) - 'A']);
            while (j - i + 1 - maxCount > k) {
                count[s.charAt(i++) - 'A']--;
            }
            res = Math.max(j - i + 1, res);
        }
        return res;
    }
}
// @lc code=end

