/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 */
// @lc code=start
import java.util.*;
/*
dfs: permutation
优化：将数组倒序查找，只查找current sum <= target sum的部分
time: O(n!)
*/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, visited, sum / k, k, 0, nums.length - 1);
    }

    private boolean dfs(int[] nums, boolean[] visited, int sum, int k, int curSum, int pos) {
        if (k == 0) return true;
        if (curSum == sum) return dfs(nums,visited, sum, k - 1, 0, nums.length - 1);
        for (int i = pos; i >= 0; --i) {
            if (!visited[i] && curSum + nums[i] <= sum) {
                visited[i] = true;
                if (dfs(nums, visited,sum, k, curSum + nums[i], i - 1)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
// @lc code=end

