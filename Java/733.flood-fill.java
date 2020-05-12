/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    /*
    BFS
    time: O(mn)
    space: O(mn)
    */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        if (curColor == newColor) return image;
        int m = image.length, n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        int[] dirs = new int[]{1, 0, -1, 0, 1};
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); ++i) {
                int[] cur = q.poll();
                for (int j = 0; j < 4; ++j) {
                    int nextR = cur[0] + dirs[j];
                    int nextC = cur[1] + dirs[j + 1];
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && image[nextR][nextC] == curColor) {
                        image[nextR][nextC] = newColor;
                        q.offer(new int[]{nextR, nextC});
                    }
                }
            }
        }
        return image;
    }
}
// @lc code=end

