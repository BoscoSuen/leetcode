/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    /*
    dfs
    time: O(n*2^n) n = 9
    sapce: O(n)
    */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 1);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> cur, int k, int n, int pos) {
        if (n <= 0 || cur.size() == k) {
            if (cur.size() == k && n == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = pos; i <= 9; ++i) {
            cur.add(i);
            dfs(res, cur, k, n - i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

