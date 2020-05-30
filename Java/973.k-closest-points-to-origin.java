/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    /*
    quick select
    https://www.jianshu.com/p/4291f821315a
    time: O(n) for average, worst O(n^2), always choose the pivot largest or smallest
    space: T(n) = O(1) + T(n/2) -> o(logn), worst O(n)
    */
    public int[][] kClosest(int[][] points, int K) {
        quickSelect(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void quickSelect(int[][] points, int start, int end, int k) {
        if (start >= end) return;
        int left = start, right = end;
        int[] pivot = points[(right - left) / 2 + left];
        while (left <= right) {
            // add = since we need also compare the left = right index with pivot(compare everything with pivot)
            while (left <= right && compare(points[left], pivot) < 0) {
                left++;
            }
            while (left <= right && compare(pivot, points[right]) < 0) {
                right--;
            }
            if (left <= right) {
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp;
                left++;
                right--;
            }
        }
        // left: start idx which num >= pivot
        // right: end indx which num >= pivot
        if (left <= k) quickSelect(points, left, end, k);
        else if (right >= k) quickSelect(points, start, right, k);
    }

    private int compare(int[] a, int[] b) {
        return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
    }
}
// @lc code=end

