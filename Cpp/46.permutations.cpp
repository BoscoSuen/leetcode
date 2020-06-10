/*
 * @lc app=leetcode id=46 lang=cpp
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        vector<bool> visited(nums.size(), false);
        vector<int> cur;
        dfs(nums, res, visited, cur, 0);
        return res;
    }

private:
    void dfs(vector<int>& nums, vector<vector<int>>& res, vector<bool>& visited, vector<int>&cur, int pos) {
        if (pos == nums.size()) {
            res.push_back(cur);
            return;
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (!visited[i]) {
                visited[i] = true;
                cur.push_back(nums[i]);
                dfs(nums, res, visited, cur, pos + 1);
                cur.pop_back();
                visited[i] = false;
            }
        }
    }
};
// @lc code=end

