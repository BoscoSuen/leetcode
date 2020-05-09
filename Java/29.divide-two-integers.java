/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    /*
    减少求商的时间复杂度，每次找到最大的2^n,然后减去再进行递归
    And Use long to avoid integer overflow cases.
    time: O(logn * logn)
    note:
    I believe the time complexity is O(logn * logn). 
    First, it is easy to see that inner while loop takes is logn. And because dvd gets reduced by at least half, 
    the outer loop is gonna be logn as well. Think about dividend = 2^10 - 1 and divisor = 2. 
    It will be res = 9 + 8 + 7 + ... + 1
    */
    public int divide(int dividend, int divisor) {
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;     // xOR
        long d1 = Math.abs((long)dividend);
        long d2 = Math.abs((long)divisor);
        if (d1 == 0 || d1 < d2) return 0;
        long res = 0;
        while (d1 >= d2) {
            long temp = d2;
            long ans = 1;
            while (temp << 1 <= d1) {
                ans <<= 1;
                temp <<= 1;
            }
            d1 -= temp;
            res += ans;
        }
        if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        return sign * (int)res;
    }
}
// @lc code=end

