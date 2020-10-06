/*
 * @lc app=leetcode id=947 lang=java
 *
 * [947] Most Stones Removed with Same Row or Column
 */

// @lc code=start
class Solution {
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) return 0;
        Set<String> visited = new HashSet<>();
        int count = 0;
        for (int[] stone : stones) {
            if (visited.add(stone[0] + "-" + stone[1])) {
                dfs(stones, visited, stone);
                count++;
            }
        }
        return stones.length - count;
    }

    private void dfs(int[][] stones, Set<String> visited, int[] stone) {
        for (int[] next : stones) {
            if ((next[0] == stone[0] || next[1] == stone[1]) && (visited.add(next[0] + "-" + next[1]))) {
                dfs(stones, visited, next);
            }
        }
    }
}
// @lc code=end

