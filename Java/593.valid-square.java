/*
 * @lc app=leetcode id=593 lang=java
 *
 * [593] Valid Square
 */

// @lc code=start
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>(Arrays.asList(dis(p1, p2), dis(p1, p3), dis(p1, p4), dis(p2, p3), dis(p2, p4), dis(p3, p4)));
        return !set.contains(0) && set.size() == 2;
    }
    
    private int dis(int[] p1, int[] p2) {
        return (Math.abs(p1[0] - p2[0])) * (Math.abs(p1[0] - p2[0])) + (Math.abs(p1[1] - p2[1])) * (Math.abs(p1[1] - p2[1]));
    }
}
// @lc code=end

