/*
 * @lc app=leetcode id=53 lang=cpp
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if (nums.empty()) return 0;
        int maxEndHere = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            maxEndHere = max(maxEndHere + nums[i], nums[i]);
            res = max(maxEndHere, res);
        }
        return res;
    }
};
// @lc code=end

