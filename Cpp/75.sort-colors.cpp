/*
 * @lc app=leetcode id=75 lang=cpp
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int red = 0, l = 0, r = nums.size() - 1;
        while (l <= r) {
            if (nums[l] == 0) swap(nums[red++], nums[l++]);
            else if (nums[l] == 2) swap(nums[l], nums[r--]);
            else ++l;
        }
    }
};
// @lc code=end

