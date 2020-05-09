/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 */

// @lc code=start
class Solution {
    // check slope, but use multiply instead of divide
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length <= 1) return true;
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        for (int i = 2; i < coordinates.length; ++i) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (dx * (y - y0) != dy * (x - x0)) return false;
        }
        return true;
    }
}
// @lc code=end

