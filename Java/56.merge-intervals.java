/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    利用一个pointer cur记录最大结束时间，并进行更新，如果当前没有interval就把cur加到结果数组中
    注意： 最后记得把最后一个cur加到结果数组中
    time: O(nlogn)
    space: O(n)
    */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int[] cur = intervals[0];
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                res.add(cur);
                cur = intervals[i];
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

