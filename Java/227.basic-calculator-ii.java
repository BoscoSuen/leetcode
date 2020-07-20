/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    /*
    记录之前的sign
    eg: 3 + 2 * 2 + 1, default sign +
    碰到运算符, sign = +，将3push, sign = +
    碰到*, sign = +, 2 push, sign = *
    碰到+, sign = *, stack.pop() = 2, push (2 * 2)
    碰到最后一个字符，sign = +, push1
    最后将stack中的结果相加
    time: O(n)
    space: O(n)
    */
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                int start = i;
                // 防止while中++i和for中++i重复，判断i+1
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    ++i;
                }
                num = Integer.parseInt(s.substring(start, i + 1));
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+') stack.push(num);
                else if (sign == '-') stack.push(-num);
                else if (sign == '*') stack.push(stack.pop() * num);
                else if (sign == '/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        for (int n : stack) {
            res += n;
        }
        return res;
    }
}
// @lc code=end

