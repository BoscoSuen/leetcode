/*
 * @lc app=leetcode id=1103 lang=java
 *
 * [1103] Distribute Candies to People
 */

// @lc code=start
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int cur = 1, pos = 0;
        while (candies > 0) {
            int n = Math.min(cur++, candies);
            candies -= n;
            res[pos++] += n;
            if (pos == num_people) {
                pos = 0;
            }
        }
        return res;
    }
}
// @lc code=end

