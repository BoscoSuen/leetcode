/*
 * @lc app=leetcode id=287 lang=cpp
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
/*
binary search
dup在左 1 1 2 3 4 小于等于dup的数=3 > mid = 2
dup在右 1 2 3 4 4 小于等于mid的数=3 = mid = 3
g(m): 找到最小的数m使得 <= m的数的count > m
time: O(nlogn)
space: O(1)
*/
public:
    int findDuplicate(vector<int>& nums) {
        int left = 0, right = nums.size();
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) ++count;
            }
            if (count > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
};
// @lc code=end

