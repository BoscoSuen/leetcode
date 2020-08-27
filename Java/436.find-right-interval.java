/*
 * @lc app=leetcode id=436 lang=java
 *
 * [436] Find Right Interval
 */

// @lc code=start
class Solution {
    /*
    treemap
    time: O(nlogn)
    space: O(n)
    */
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; ++i) {
            map.put(intervals[i][0], i);
        }
        
        for (int i = 0; i < intervals.length; ++i) {
            Integer ceiling = map.ceilingKey(intervals[i][1]);
            res[i] = ceiling != null ? map.get(ceiling) : -1;
        }
        return res;
    }
}
// @lc code=end

