/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    思路同3Sum, 遍历前两个数，利用two pointer找后面两个数，注意遍历和内部的"两次"去重
    time: O(n^3)
    space: O(1)
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1,right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> cur = Arrays.asList(new Integer[]{nums[i], nums[j], nums[left], nums[right]});
                        res.add(cur);
                        // 内部去重  -2 0  1 1 1 1 1 1 1 1 
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if (sum > target) right--;
                    else left++;
                }
            }
        }
        return res;           
    }
}
// @lc code=end

