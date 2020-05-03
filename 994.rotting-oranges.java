/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    /*
    BFS, 注意rotting之后要把对应的grid设置为2
    time: O(mn)
    space:O(mn)
    */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int total = 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) ++total;
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    ++total;
                }
            }
        }
        int time = 0;
        int[] dir = new int[]{1, 0, -1, 0, 1};
        if (total == 0) return 0;
        while (!q.isEmpty()) {
            int size = q.size();
            total -= size;
            if (total == 0) return time;
            for (int i = 0; i < size; ++i) {
                int[] cur = q.poll();
                int row = cur[0];
                int col = cur[1];
                for (int j = 0 ; j < 4; ++j) {
                    int nextRow = row + dir[j];
                    int nextCol = col + dir[j + 1];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n || grid[nextRow][nextCol] != 1) continue;
                    q.offer(new int[]{nextRow, nextCol});
                    grid[nextRow][nextCol] = 2; // set new status
                }
            }
            time++;
        }
        return -1;
    }
}
// @lc code=end

