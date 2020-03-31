/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    /*
    先利用递归尽可能计算n/2次方
    分奇偶得出x^n = A*A or x^n = A*A*x
    time: O(logn)
    space: O(n)
    */
    public double myPow(double x, int n) {
        if (n < 0) return 1.0 / pow(x, n);
        else return pow(x, n);
    }
    public double pow(double x, int n) {
        if (n == 0) return 1.0;
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
}
// @lc code=end

