/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 */

// @lc code=start
class Solution {
    /*
    dfs + bfs
    对于其中一个island,用dfs将其全部染为2，并全部加入q中
    对于q进行bfs,每过一层将当前的染为2，如果碰到1就返回step
    time: O(mn)
    space: O(mn)
    */
    int[] dirs = new int[]{-1, 0, 1, 0, -1};
    public int shortestBridge(int[][] A) {
        Queue<int[]> q = new LinkedList<>();
        loop:
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, q);
                    break loop;
                }
            }
        }
        int step = 0;
        while (!q.isEmpty()) { 
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; ++j) {
                    int nextI = cur[0] + dirs[j];
                    int nextJ = cur[1] + dirs[j + 1];
                    if (nextI < 0 || nextJ < 0 || nextI >= A.length || nextJ >= A[0].length || A[nextI][nextJ] == 2) continue;
                    if (A[nextI][nextJ] == 1) {
                        return step;
                    }
                    q.offer(new int[]{nextI, nextJ});
                    A[nextI][nextJ] = 2;
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] A, int i, int j, Queue<int[]> q) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] != 1) return;
        A[i][j] = 2;
        q.offer(new int[]{i, j});
        dfs(A, i - 1, j, q);
        dfs(A, i + 1, j, q);
        dfs(A, i, j - 1, q);
        dfs(A, i, j + 1, q);
    }
}
// @lc code=end

