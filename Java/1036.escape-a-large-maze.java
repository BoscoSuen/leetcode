/*
 * @lc app=leetcode id=1036 lang=java
 *
 * [1036] Escape a Large Maze
 */

// @lc code=start
class Solution {
    /*
    最多200个被block, 如果走的曼哈顿距离>200说明可以
    如果target四周都被block,也不行 所以需要双向dfs
    */
    int[] dirs = new int[]{1, 0, -1, 0, 1};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] block : blocked) {
            blockedSet.add(block[0] + "->" + block[1]);
        }
        return dfs(source, target, source, blockedSet, new HashSet<>()) && dfs(target, source, target, blockedSet, new HashSet<>());
    }
    
    private boolean dfs(int[] source, int[] target, int[] cur, Set<String> blocked, Set<String> visited) {
        if (cur[0] == target[0] && cur[1] == target[1]) {
            return true;
        }
        if (Math.abs(source[0] - cur[0]) + Math.abs(source[1] - cur[1]) > 200) {
            return true;
        }
        for (int i = 0; i < 4; ++i) {
            int nextR = cur[0] + dirs[i];
            int nextC = cur[1] + dirs[i + 1];
            if (nextR >= 0 && nextR < 1e6 && nextC >= 0 && nextC < 1e6 && visited.add(nextR + "->" + nextC) 
                && !blocked.contains(nextR + "->" + nextC)) {
                if (dfs(source, target, new int[]{nextR, nextC}, blocked, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

