/*
 * @lc app=leetcode id=815 lang=java
 *
 * [815] Bus Routes
 */

// @lc code=start
class Solution {
    /*
    BFS
    time: O(V+E) E ~ n^2
    space: O(V+E)
    */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0) return -1;
        if (S == T) return 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int bus : routes[i]) {
                map.putIfAbsent(bus, new HashSet<>());
                map.get(bus).add(i);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == T) return count;
                for (int bus : map.get(cur)) {
                    if (visited.add(bus)) {
                        for (int i = 0; i < routes[bus].length; ++i) {
                            q.offer(routes[bus][i]);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
// @lc code=end

