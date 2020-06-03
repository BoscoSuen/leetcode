/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 */

// @lc code=start
class Solution {
    /*
    按照A[0] - A[1]排序，A[0] - A[1]差值大的按greedy被分配对应值小的
    eg: [30, 200] -> -170, 放入A中, [200, 30] -> 170 放入B中
    time: O(nlogn)
    space: O(1)
    */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1] - (b[0] - b[1])));
        int res = 0;
        for (int i = 0; i < costs.length; ++i) {
            res += i < costs.length / 2 ? costs[i][0] : costs[i][1];
        }
        return res;
    }
}
// @lc code=end

