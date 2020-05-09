/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
import java.util.*;
class Solution {
    // sliding window, track the max hash set size
    // time: O(n)
    // space: O(n)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int res = 0;
        for (int j = 0; j < s.length(); ++j) {
            while (!set.add(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            res = Math.max(res,set.size());
        }
        return res;
    }
}
// @lc code=end

