/*
 * @lc app=leetcode id=1162 lang=java
 *
 * [1162] As Far from Land as Possible
 */

// @lc code=start
class Solution {
    /*
    判断多久1能覆盖所有0
    time: O(mn)
    space: O(mn)
    */
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[] dirs = new int[]{1, 0, -1, 0, 1};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; ++i) {
                    int nextR = cur[0] + dirs[i];
                    int nextC = cur[1] + dirs[i + 1];
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && grid[nextR][nextC] == 0) {
                        grid[nextR][nextC] = 1;
                        q.offer(new int[]{nextR, nextC});
                    }
                }
            }
            step++;
        }
        return step - 1 == 0 ? -1 : step - 1;
    }
}
// @lc code=end

