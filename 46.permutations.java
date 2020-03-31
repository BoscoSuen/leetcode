/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    permutation需要一个visited数组记录已访问过的数，dfs进入下一层的时候不需要记录当前pos
    time: O(n!)
    space: O(n)
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, res, cur);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}
// @lc code=end

