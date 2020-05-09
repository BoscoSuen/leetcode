/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        int left = 1, right = num;
        while (left < right) {
            long mid = (right - left) / 2 + left;
            // mid * mid may exceed int limit
            if (mid * mid == num) return true;
            if (mid * mid > num) right = (int)mid;
            else left = (int)mid + 1;
        }
        return false;
    }
}
// @lc code=end

