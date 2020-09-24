/*
 * @lc app=leetcode id=675 lang=java
 *
 * [675] Cut Off Trees for Golf Event
 */

// @lc code=start
class Solution {
    /*
    将所有target按照高度排序，依次bfs
    time: O(mn*mn)
    space: O(mn)
    */
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for (int i = 0; i < forest.size(); ++i) {
            for (int j = 0; j < forest.get(0).size(); ++j) {
                if (forest.get(i).get(j) > 1) {
                    pq.offer(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        int res = 0;
        int[] start = new int[]{0, 0};
        while (!pq.isEmpty()) {
            int[] target = pq.poll();
            int steps = bfs(forest, start, target);
            if (steps == -1) {
                return -1;
            }
            res += steps;
            start[0] = target[0];
            start[1] = target[1];
        }
        return res;
    }
    
    private int bfs(List<List<Integer>> forest, int[] start, int[] target) {
        int m = forest.size(), n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int[] dirs = new int[]{1, 0, -1, 0, 1};
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = q.poll();
                if (cur[0] == target[0] && cur[1] == target[1]) {
                    return steps;
                }
                for (int j = 0; j < 4; ++j) {
                    int nextR = cur[0] + dirs[j];
                    int nextC = cur[1] + dirs[j + 1];
                    if (nextR >= 0 && nextC >= 0 && nextR < m && nextC < n &&
                        !visited[nextR][nextC] && forest.get(nextR).get(nextC) != 0) {
                        visited[nextR][nextC] = true;
                        q.offer(new int[]{nextR, nextC});
                    } 
                }
            }
            steps++;
        }
        return -1;
    }
}
// @lc code=end

