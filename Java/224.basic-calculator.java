/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    /*
    利用一个stack存储括号内的计算结果
    eg: 1 + (3 + 2) + 6
    碰到加减号把之前的计算结果加到res中
    碰到左括号将res和运算符push进stack中，eg: res = 1, sign = +
    碰到右括号运算结束之后在pop出res和运算符进行运算: 1 + (res = 3 + 2)
    */
        public int calculate(String s) {
            int sign = 1;
            char[] chs = s.toCharArray();
            Stack<Integer> stack = new Stack<>();
            int res = 0;
            for (int i = 0; i < chs.length; ++i) {
                if (Character.isDigit(chs[i])) {
                    int num = chs[i] - '0';
                    while(i + 1 < chs.length && Character.isDigit(chs[i + 1])) {
                        num = 10 * num + chs[i + 1] - '0';
                        ++i;
                    }
                    res += sign * num;
                } else if (chs[i] == '+') {
                    sign = 1;
                } else if (chs[i] == '-') {
                    sign = -1;
                } else if (chs[i] == '(') {
                    stack.push(res);
                    stack.push(sign);
                    sign = 1;
                    res = 0;
                } else if (chs[i] == ')') {
                    res = stack.pop() * res + stack.pop();
                }
            }
            return res;
        }
    }
// @lc code=end

