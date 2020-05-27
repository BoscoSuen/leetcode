/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    /*
    topological sort
    time: O(V+E)
    space: O(V+E)
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph[i] = new ArrayList<>();   // cannot use Arrays.fill()
        }
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            graph[pair[0]].add(pair[1]);
            indegree[pair[1]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            numCourses--;
            List<Integer> list = graph[cur];
            for (int next : list) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return numCourses == 0;
    }
}
// @lc code=end

