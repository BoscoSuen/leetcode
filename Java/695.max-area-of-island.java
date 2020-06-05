/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    /*
    union find
    time: O(mn)
    space: O(mn)
    */
    int[] dirs = new int[]{1, 0, -1, 0, 1};
    class UnionFind {
        int[] parent;
        int[] size;
        int[] rank;
        UnionFind(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            parent = new int[m * n];
            for (int i = 0; i < parent.length; ++i) {
                parent[i] = i;
            }
            size = new int[m * n];
            rank = new int[m * n];
            Arrays.fill(size, 1);
        }

        public int union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return size[px];
            if (rank[px] > rank[py]) {
                parent[py] = px;
                size[px] = size[px] + size[py];
                return size[px];
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
                size[py] = size[px] + size[py];
                return size[py];
            } else {
                parent[py] = px;
                rank[px]++;
                size[px] = size[px] + size[py];
                
                return size[px];
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int getSize(int x) {
            return size[find(x)];
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int max = 0;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != 1) continue;
                int pos = i * n + j;
                // get the cur size in the cur pos and update max, then do union
                max = Math.max(max, uf.getSize(pos));
                for (int k = 0; k < 4; ++k) {
                    int nextI = i + dirs[k];
                    int nextJ = j + dirs[k + 1];
                    if (nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n || grid[nextI][nextJ] != 1) continue;          
                    max = Math.max(max, uf.union(pos, nextI * n + nextJ));
                }
            }
        }
        return max;
    }
}
// @lc code=end

