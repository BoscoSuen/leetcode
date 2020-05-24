/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
class Solution {
    /*
    backtracking
    每次对应的n-1对应不同递归深度更改不同位
    每次选择不变或者和对应位与1xor
    这样可以做到每次只更改一位
    time: O(2^n)
    space: O(n)
    */
    int num = 0;
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        dfs(res, n);
        return res;
    }

    private void dfs(List<Integer> res, int n) {
        if (n == 0) {
            res.add(num);
            return;
        }
        dfs(res, n - 1);
        num ^= 1 << (n - 1);
        dfs(res, n - 1);
    }
}
// @lc code=end

