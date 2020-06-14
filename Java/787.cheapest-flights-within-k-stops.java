/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    /*
    Dijkstra's algo
    time: O((E+V)logV)
    space: O(V+E)
    */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] f : flights) {
            map.putIfAbsent(f[0], new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1], f[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            // {price, start, remain stops}
            if (cur[1] == dst) return cur[0];
            if (cur[2] > 0) {
                if (!map.containsKey(cur[1])) continue;
                for (int[] i : map.get(cur[1])) {
                    pq.offer(new int[]{cur[0] + i[1], i[0], cur[2] - 1});
                }
            }
        }
        return -1;
    }
}
// @lc code=end

