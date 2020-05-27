/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class Solution {
    /*
    graph coloring
    建立无向图，将颜色分为0(unknown), 1(red), -1(blue)
    对于没有染色的进行dfs,下一层染为相反颜色，如果不能即将染色的颜色和当前颜色颜色相同，则返回false
    time: O(V+E)
    space: O(V+E)
    */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes == null || dislikes.length == 0) return true;
        int[][] graph = new int[N][N];
        for (int [] arr : dislikes){
            graph[arr[0] - 1][arr[1] - 1] = 1;
            graph[arr[1] - 1][arr[0] - 1] = 1;
        }
        int[] colors = new int[N];
        for (int i = 0; i < N; ++i) {
            if (colors[i] == 0 && !dfs(colors, graph, i, 1)) return false;
        }
        return true;
    }
    
    private boolean dfs(int[] colors, int[][] graph, int idx, int color) {
        colors[idx] = color;    // default red
        for (int i = 0; i < colors.length; ++i) {
            if (graph[idx][i] == 1) {
                if (colors[i] == color) return false;
                if (colors[i] == 0 && !dfs(colors, graph, i, -color)) return false;
            }
        }
        return true;
    }
}
// @lc code=end

