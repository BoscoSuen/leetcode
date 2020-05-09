/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    /*
    注意数字越界，用long来存储最后结果
    time: O(n)
    space: O(1)
    */
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        char first = str.charAt(0);
        if (!(first == '-' || first == '+' || Character.isDigit(first))) {
            return 0;
        }
        int sign = 1, start = 0;
        if (first == '-') {
            sign = -1;
            start = 1;
        } else if (first == '+') {
            start = 1;
        }
        long res = 0;
        for (int i = start; i < str.length(); ++i) {
            if (!Character.isDigit(str.charAt(i))) break;
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;  // long 也有可能越界，所以要在for循环里面判断
            if (sign == -1 && sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)res * sign;
    }
}
// @lc code=end

