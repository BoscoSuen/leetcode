/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    /*
    start from the middle and expand the palindrom string
    time: O(n^2)
    space: O(n)
    */
    int max = 0;
    String res = "";
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return res;
        for (int i = 0; i < s.length(); ++i) {
            extend(s,i,i);
            extend(s,i,i + 1);
        }
        return res;
    }

    private void extend(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left + 1 > max) {
            max = right - left + 1;  // we need to track r-l+1 instead of r-l-1, for "abcd", l = 1,r=2,max=0
            res = s.substring(left + 1,right);  // current left != right
        }
    }
}
// @lc code=end

