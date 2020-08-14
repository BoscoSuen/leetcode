/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    /*
    bucket sort
    将大于citation length的放入bucket末尾
    从后往前找第一个满足h-index定义的值
    time: O(n)
    space: O(n)
    */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int[] bucket = new int[citations.length + 1];
        for (int citation : citations) {
            bucket[citation >= citations.length ? citations.length : citation]++;
        }
        int sum = 0;
        for (int i = citations.length; i >= 0; --i) {
            sum += bucket[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
// @lc code=end

