/*
 * @lc app=leetcode id=939 lang=java
 *
 * [939] Minimum Area Rectangle
 */

// @lc code=start
class Solution {
    /*
    using a hashmap<Integer,Set> store the x and set of y
    find two diagonal points and check if the other points exist
    time: O(n^2)
    space: O(n)
    */
    public int minAreaRect(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.putIfAbsent(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (i == j || points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) {
                    res = Math.min(res, Math.abs((points[i][0] - points[j][0]) * (points[i][1] - points[j][1])));
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
// @lc code=end

