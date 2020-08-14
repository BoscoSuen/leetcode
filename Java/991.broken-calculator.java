/*
 * @lc app=leetcode id=991 lang=java
 *
 * [991] Broken Calculator
 */

// @lc code=start
class Solution {
    /*
    从Y到X
    如果Y大于x就一直除2(或者+1再除2)
    之后再一次一次加
    time: O(log(Y/X))
    space: O(1)
    */
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (Y > X) {
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
            count++;
        }
        return count + X - Y;
    }
}
// @lc code=end

