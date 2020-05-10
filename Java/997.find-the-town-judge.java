/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    /*
    trust is a directed graph, find indegree - outdegree  = n - 1
    time: O(n)
    space: O(n)
    */
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        for (int[] i : trust) {
            count[i[0]]--;
            count[i[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
}
// @lc code=end

