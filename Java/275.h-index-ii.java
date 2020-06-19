/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */

// @lc code=start
class Solution {
    /*
    binary search, 用citations[mid] 和 n - mid来比较
    eg: 0, 1, 3, 5, 6 相等, 返回n - mid = 3
    eg: 0, 1, 1, 5, 6 citations[mid]太小 往右找
    eg: 0, 4, 4, 5, 6 citations[mid]太大 往左找
    time: O(nlogn)
    space: O(1)
    */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (citations[mid] == n - mid) return n - mid;
            else if (citations[mid] > n - mid) {
                right = mid;
            } else left = mid + 1;
        }
        return n - left;
    }
}
// @lc code=end

