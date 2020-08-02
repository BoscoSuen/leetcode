/*
 * @lc app=leetcode id=757 lang=java
 *
 * [757] Set Intersection Size At Least Two
 */

// @lc code=start
class Solution {
    /*
    greedy 区间排序
    记录当前区间的最后两个数字，如果之后的区间比这个大就把需要添加的数字加进去，否则就跳过，用之前区间的数字也能覆盖
    time:
    */
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]));
        int n1 = -1;
        int n2 = -1;
        int count = 0;
        for (int[] i : intervals) {
            if (n1 >= i[0]) {
                // [3,4] [1,2]
                continue;
            }
            else if (n2 < i[0]) {
                // [1,2] [3,4]
                count += 2;
                n2 = i[1];
                n1 = i[1] - 1;
            } else {
                // [2,3] [2,4]
                count++;
                n1 = n2;
                n2 =i[1];
            }
        }
        return count;
    }
}
// @lc code=end

