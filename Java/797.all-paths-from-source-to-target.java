/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    /*
    dfs: 注意base case是到最后一个index,即length - 1
    time: O(n*2^n)
    space: O(n*2^n)
    */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        curList.add(0);
        dfs(graph, res, 0, curList);
        return res;
    }
    
    private void dfs(int[][] graph, List<List<Integer>> res, int pos, List<Integer> curList) {
        if (pos == graph.length - 1) {
            res.add(new ArrayList<>(curList));
            return;
        }
        
        for (int next : graph[pos]) {
            curList.add(next);
            dfs(graph, res, next, curList);
            curList.remove(curList.size() - 1);
        }
    }
}
// @lc code=end

