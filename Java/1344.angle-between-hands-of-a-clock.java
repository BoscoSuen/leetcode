/*
 * @lc app=leetcode id=1344 lang=java
 *
 * [1344] Angle Between Hands of a Clock
 */

// @lc code=start
class Solution {
    public double angleClock(int hour, int minutes) {
        hour %= 12;
        minutes %= 60;
        double mAngle = (double)minutes * 360 / 60;
        double hAngle = (double)hour * 360 / 12 + (double)minutes / 2;
        double angle = Math.abs(mAngle - hAngle);
        return angle <= 180 ? angle : 360 - angle;
    }
}
// @lc code=end

