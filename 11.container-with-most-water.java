/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        /*
        从两端开始扫描，如果哪一端的高度小，就移动哪一端，然后track最大面积
        time: O(n)
        space: O(1)
        */
        int left = 0, right = height.length - 1;
        int res = Math.min(height[left], height[right]) * (right - left);
        while (right > left) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > res) res = area;
        }
        return res;
    }
}
// @lc code=end

