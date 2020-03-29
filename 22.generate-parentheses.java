/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    backTracking,maintain the number of open and close paranthesis
    time: O(2^n)
    space: O(n)
    */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }


    public void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n && open == close) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            helper(res, sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            helper(res, sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
// @lc code=end

