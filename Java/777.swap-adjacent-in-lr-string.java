/*
 * @lc app=leetcode id=777 lang=java
 *
 * [777] Swap Adjacent in LR String
 */

// @lc code=start
class Solution {
    /*
    X看作空格,R看作向右走,L看作向左走,其中不能跨过L/R
    LR 频率不想等 返回false
    如果对于非space的两个位置的字母不相同，则返回false(会跨过L,R)
    如果L的index更小则返回false
    如果R的index更大则返回false
    time: O(n)
    space: O(1)
    */
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        int i = 0, j = 0;
        while (i < start.length() || j < end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') ++i;
            while (j < end.length() && end.charAt(j) == 'X') ++j;
            if (i == start.length() && j == end.length()) return true;
            if (i == start.length() || j == end.length()) return false;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return true;
    }
}
// @lc code=end

