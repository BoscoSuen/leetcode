/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    对于permutation的去重的操作，需要对数组进行排序
    判断去重时，只有当前元素和当前一个元素相等并且*前一个元素未访问时*,才进行去重
               1    1   2
    visited    f                1 1已排列
    visited    t                1 1未排列，可能是第一个permutation
    time: O(n!)
    space: O(n)
    */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, res, cur);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
// @lc code=end

