/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    /*
    因为是比较end,所以按照end排序
    找到排序之后最多有多少non overlapping
    time: O(nlogn)
    space: O(1)
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
// @lc code=end

