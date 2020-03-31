/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    dfs + backtracking
    下一层遍历的起始pos和上一层一样
    time: O(N^target) where N is a length of candidates array.
    space: O(target)
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, res, new ArrayList<>(), 0, target);
        return res;
    }

    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> cur, int start, int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            cur.add(candidates[i]);
            helper(candidates, res, cur, i, remain - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

