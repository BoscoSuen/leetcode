/*
 * @lc app=leetcode id=803 lang=java
 *
 * [803] Bricks Falling When Hit
 */

// @lc code=start
/*
union find, 对于剩下的bricks, 找到find(0)的数量，减去可以得到掉落砖块的数量
由于之前掉落会改变后面的状态，hit从后往前更新，将之前的hit设置为2
回滚的时候将2设置回1重新union，更新find(0)的值
time:O(mn) for union O(mn * hits.length)    find O(1) amortized time
space: O(mn)   
*/
class Solution {
    class UF {
        int[] parent;
        int[] size;
        
        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        
        private void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY) {
                parent[parentY] = parentX;
                size[parentX] += size[parentY];
            }
        }
        
        private int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
    UF uf;
    int m, n;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        m = grid.length;
        n = grid[0].length;
        uf = new UF(m * n + 1);
        // set all hit to 2
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = 2;
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    unionGrid(uf, grid, i, j);
                }
            }
        }
        int[] res = new int[hits.length];
        int i = res.length - 1;
        int left = uf.size[uf.find(0)];
        while (i >= 0) {
            int hitR = hits[i][0];
            int hitC = hits[i][1];
            if (grid[hitR][hitC] == 2) {
                grid[hitR][hitC] = 1;
                unionGrid(uf, grid, hitR, hitC);
                int curLeft = uf.size[uf.find(0)];
                res[i] = Math.max(0, curLeft - left - 1);    // 减去hit掉的那一个 或结果是0
                left = curLeft;
            }

            --i;
        }
        return res;
    }
    
    private void unionGrid(UF uf, int[][] grid, int r, int c) {
        int pos = getPosition(r, c);
        if (r == 0) uf.union(0, pos);   // union to top
        int[] dirs = new int[]{1, 0, -1, 0, 1};
        for (int i = 0; i < 4; ++i) {
            int nextR = r + dirs[i];
            int nextC = c + dirs[i + 1];
            if (nextR >= 0 && nextC >= 0 && nextR < m && nextC < n && grid[nextR][nextC] == 1) {
                int nextPos = getPosition(nextR, nextC);
                uf.union(pos, nextPos);
            }
        }
    }
    
    private int getPosition(int r, int c) {
        return n * r + c + 1;
    }
}
// @lc code=end

