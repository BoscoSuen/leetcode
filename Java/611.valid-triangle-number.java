/*
 * @lc app=leetcode id=611 lang=java
 *
 * [611] Valid Triangle Number
 */

// @lc code=start
class Solution {
    /*
    类似3sum
    先排序，k从大到小遍历
    找到两个indexi, j使得nums[i] + nums[j] > nums[k],
    这样i向右移的数都满足.eg:
     i          j   k
    [3, 19, 22, 24, 35, 82, 84]
    time: O(n^2)
    space: O(1)
    */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int k = nums.length - 1; k >= 0; --k) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
// @lc code=end

