/*
 * @lc app=leetcode id=300 lang=cpp
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
/*
创建和维护一个递增数组, 并在此数组上进行修改,
依次取源数据, 大数:append, 中间数:替换。维护数组的过程中，保证该升序序列在同长度升序序列中末尾最小
如果要维护的位置到了末尾，则对应的结果+1，说明有一个大树让递增序列的长度+1
[4,5,6,3]
len = 1     tail[0] = 4 -> 3    更新tail[0]以保证当前递增序列是最小且最长的,eg[4,6,9,7,8], 遍历到7时应更新对应tail
len = 2     tail[1] = 5
len = 3     tail[2] = 6
找到对应update tail的位置用binary search, 因为tail数组是递增的，对应g(m): tail[target] >= current num
time: O(nlogn)
space: O(n)
*/
public:
    int lengthOfLIS(vector<int>& nums) {
        if (!nums.size()) return 0;
        vector<int> tails(nums.size(), 0);
        int size = 0;
        for (int num : nums) {
            int left = 0, right = size;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (tails[mid] >= num) {
                    right = mid;
                } else left = mid + 1;
            }
            tails[left] = num;
            if (left == size) ++size;
        }
        return size;
    }
};
// @lc code=end

