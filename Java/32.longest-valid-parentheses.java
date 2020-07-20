/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    /*
    利用一个stack来储存(的index
    如果当前stack是empty,就把start记在当前的下一个位置
    如果碰到)就pop,如果pop之后是空,eg: (), 就用start来更新res
    如果不是空,eg : (()就用stack.peek来更新res
    */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0, start = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start + 1);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

