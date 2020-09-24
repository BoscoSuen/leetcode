/*
 * @lc app=leetcode id=630 lang=java
 *
 * [630] Course Schedule III
 */

// @lc code=start
class Solution {
    /*
    greedy
    按照结束时间排序
    track当前时间，遍历课程，将其中的duration按从大到小排序加入到pq中
    如果当前时间超过结束时间，当前时间减去pq最顶端课程(耗时太长)
    time: O(nlogn)
    space: O(n)
    */
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0) return 0;
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.offer(course[0]);
            if (time > course[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}
// @lc code=end

