/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 */

// @lc code=start
class Solution {
    /*
    dfs
    注意: list.toArray()只能返回Object[], 如果要返回int[]用stream或者一个一个添加
    time: O(10 * 2^N)
    space: O(n)
    */
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 0) return new int[]{0};
        List<Integer> res = new ArrayList<>();
        dfs(res, N, K, 0);
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    private void dfs(List<Integer> res, int N, int K, int cur) {
        if (N == 0) {
            res.add(cur);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            if (cur == 0 && i == 0 && N != 1) continue; // 0 is valid
            if (cur == 0) {
                dfs(res, N - 1, K, i);  // first digit随意
            } else if (Math.abs(cur % 10 - i) == K) {
                dfs(res, N - 1, K, cur * 10 + i);
            }
        }
    }
}
// @lc code=end

