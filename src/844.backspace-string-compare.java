/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    /*
    two pointer 
    time: O(n) space: O(1)
    */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    --i;
                    ++skipS;
                } else if (skipS > 0) {
                    --skipS;
                    --i;
                } else break;
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    --j;
                    ++skipT;
                } else if (skipT > 0) {
                    --skipT;
                    --j;
                } else break;
            }
            if ((i >= 0) != (j >= 0)) return false;
            if ((i >= 0) && (j >= 0) && (S.charAt(i) != T.charAt(j))) return false;
            --i;
            --j;
        }
        return true;
    }
}
// @lc code=end

