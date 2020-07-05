/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start
class Solution {
    /*
    binary search, 找到最小的k,使得k(k+1)/2 > n, 返回k - 1
    涉及到乘法 用long来储存变量
    time: O(logn)
    space: O(1)
    */
    public int arrangeCoins(int n) {
        if (n == 0) return 0;
        long left = 1, right = (long)n + 1;
        System.out.println(right);
        while (left < right) {
            long mid = (right - left) / 2 + left;
            if (mid * (mid + 1) / 2 > n) right = mid;
            else left = mid + 1;
        }
        return (int)left - 1;
    }
}
// @lc code=end

