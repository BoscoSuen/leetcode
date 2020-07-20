/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    /*
    topological sort
    对于prerequisite，上课的顺序是prerequisite[1] -> prerequisite[0]
    time: O(V+E)
    space: O(V+E)
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        if (numCourses == 0) return res;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.putIfAbsent(p[1], new ArrayList<>());
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if(indegree[i] == 0) q.offer(i);
        }
        int pos = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[pos++] = cur;
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

        }
        return pos == numCourses ? res : new int[0];
    }
}
// @lc code=end

