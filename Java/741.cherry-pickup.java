/*
 * @lc app=leetcode id=741 lang=java
 *
 * [741] Cherry Pickup
 */

// @lc code=start

/*
dfs + memo
不能使用greedy, 第一次去最大，然后返回再求一次
eg: 
1 1 1 0 0
0 0 1 0 0
1 0 1 0 1
0 0 1 0 0
0 0 1 1 1
如果使用greedy第一次去最大的pick up path,返回的时候两侧的樱桃最多取到一个，但实际上所有的樱桃都能取到
将问题转化为：有两个人同时从(n-1,n-1)的位置往(0,0)走，求max pick up 
subproblem: 对于两个从(x1, y1), (x2, y2)开始往(0,0)走的人，由于他们之前走的步数一样，所以有
x1 + y1 = x2 + y2
bottom-up dp
dp[x1, y1, x2]: 从(x1, y1), (x2, y2)开始往(0,0)走的max pick up
dp(r1, c1, r2) = grid[r1][c1] + (if not same position)grid[r2][c2] + 
                 max_element(dp(r1 - 1, c1, r2 - 1), dp(r1, c1 - 1, r2 - 1), dp(r1 - 1, c1, r2), dp(r1, c1 - 1, r2))
time: O(n^3)
space: O(n^3)                 
*/
class Solution {
    int n;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        int[][][] memo = new int[n][n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, dfs(grid, memo, n - 1, n - 1, n - 1));  // in case there is no solution 
    }

    private int dfs(int[][] grid, int[][][] memo, int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if (r1 < 0 || c1 < 0 || r2 < 0 || c2 < 0) return -1;
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) return -1;
        if (r1 == 0 && c1 == 0) return grid[r1][c1];   // dfs base case, 不能用下一层的返回来计算，否则会返回-1  
        if (r2 == 0 && c2 == 0) return grid[r2][c2];
        if (memo[r1][c1][r2] != Integer.MIN_VALUE) return memo[r1][c1][r2];
        int res = Math.max(Math.max(dfs(grid, memo, r1 - 1, c1, r2 - 1), dfs(grid, memo, r1, c1 - 1, r2 - 1)),
                           Math.max(dfs(grid, memo, r1 - 1, c1, r2), dfs(grid, memo, r1, c1 - 1, r2)));
        if (res < 0) {
            memo[r1][c1][r2] = -1;
            return -1;
        }
        res += grid[r1][c1];
        if (r1 != r2 || c1 != c2) res += grid[r2][c2];
        memo[r1][c1][r2] = res;
        return res;
    }
}
// @lc code=end
