/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    /*
    用两个二维数组记录有哪些grid有flow(visited), 从两边分别进行dfs, 找到重复的grid
    as we check the water flood from the ocean to the grid, so the water from ocean need flow to the cell which is higher than the current grid.
    time: O(n^3)
    space: O(n^2)
    */
    int[] dirs = new int[]{-1,0,1,0,-1};
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            dfs(matrix, p, i, 0);
            dfs(matrix, a, i, n - 1);
        }
        for (int j = 0; j < n; ++j) {
            dfs(matrix, p, 0, j);
            dfs(matrix, a, m - 1, j);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (p[i][j] && a[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; ++k) {
            int nextI = i + dirs[k];
            int nextJ = j + dirs[k + 1];
            if (nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n || visited[nextI][nextJ] || matrix[nextI][nextJ] < matrix[i][j]) continue;
            dfs(matrix, visited, nextI, nextJ);
        }
    }
}
// @lc code=end

