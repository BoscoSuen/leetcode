/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    去重需要对数组进行排序，然后用左右pointer来找内部的two sum解
    time: O(n^2)
    space: O(1)
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // avoid duplicate result
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    List<Integer> cur = Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]});
                    res.add(cur);
                    // 内部元素去重：case -2 0 0 0 2 2 2
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] > -nums[i]) right--;
                else left++;
            }
        }
        return res;
    }
}
// @lc code=end

