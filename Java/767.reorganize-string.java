/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    /*
    先放频率最高的字符，再按位置插入
    time: O(n)
    space: O(1)
    */
    public String reorganizeString(String S) {
        int[] freq = new int[26];
        char maxChar = 'a';
        int maxFreq = 0;
        for (char c : S.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > maxFreq) {
                maxChar = c;
                maxFreq = freq[c - 'a'];
            }
        }
        if (maxFreq > (S.length() + 1) / 2) return "";  // "aba"
        char[] res = new char[S.length()];
        int i = 0;
        while (freq[maxChar - 'a']-- > 0) {
            res[i] = maxChar;
            i += 2;
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (freq[c - 'a']-- > 0) {
                if (i >= S.length()) i = 1;
                res[i] = c;
                i += 2;
            }
        }
        return new String(res);
    }
}
// @lc code=end

