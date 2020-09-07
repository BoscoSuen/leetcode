/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */

// @lc code=start
class Solution {
    /*
    记录缝隙的坐标，找到出现的次数最多的次数，用n - max
    time: o(mn)
    space: O(n)
    */
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> l : wall) {
            int sum = 0;
            for (int i = 0; i < l.size() - 1; ++i) {
                sum += l.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return n - max;
    }
}
// @lc code=end

