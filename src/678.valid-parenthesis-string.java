/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {
    /*
    利用两个指针，min&max,max记录最多需要多少个),min记录最少需要多少个)
    如果max < 0说明)太多，直接返回false
    如果碰到*,max++, min相应减少
    最后判断min是否等于0
    time: O(n)
    space: O(1)
    */
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                min++;
                max++;
            } else if(c == ')') {
                max--;
                min = Math.max(min - 1, 0);
            } else {
                max++;
                min = Math.max(min - 1, 0);
            }
            if (max < 0) return false;
        }
        return min == 0;
    }
}
// @lc code=end

