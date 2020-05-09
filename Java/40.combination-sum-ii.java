/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    dfs,注意去重要先进行数组排序
    time: O(2^n) choose or not choose
    space: O(N)
    */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int pos) {
        if (target < 0) return;
        if (target == 0) res.add(new ArrayList<>(cur));
        for (int i = pos; i < candidates.length; ++i) {
            if (i > pos && candidates[i] == candidates[i - 1]) continue;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], res, cur, i + 1);
            cur.remove(cur.size() -1);
        }
    }
}
// @lc code=end

