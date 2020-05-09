/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
/*
Dijkstra + ballman-ford + Floyd-Warshall
https://paper.dropbox.com/doc/LC743-Network-Delay-Time--AzDyhNMspi3iyNjBWoQvn7ebAg-TPF70o8aKjua4IyP4UUE4
*/
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        pq.offer(new int[]{K ,0});
        boolean[] visited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;
            visited[cur[0]] = true;
            if (--N == 0) return cur[1];
            if (map.containsKey(cur[0])) {
                for (int[] next : map.get(cur[0])) {
                    pq.offer(new int[]{next[0], cur[1] + next[1]});
                }
            }
        }
        return -1;
    }
}
// @lc code=end

