/*
 * @lc app=leetcode id=391 lang=java
 *
 * [391] Perfect Rectangle
 */

// @lc code=start
class Solution {
    /*
    requirement:
    找到最左下和最右上的顶点，其组成的面积应等于所有小矩形的面积的和
    内部的顶点的重复次数为偶数次，最外的顶点的重复次数只有一次，利用一个set来判断
    time: O(n)
    space: O(1)
    */
    public boolean isRectangleCover(int[][] rectangles) {
        int r1 = Integer.MAX_VALUE, c1 = Integer.MAX_VALUE;
        int r2 = Integer.MIN_VALUE, c2 = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        int area = 0;
        for (int[] rec : rectangles) {
            r1 = Math.min(r1, rec[0]);
            c1 = Math.min(c1, rec[1]);
            r2 = Math.max(r2, rec[2]);
            c2 = Math.max(c2, rec[3]);
            String point1 = rec[0] + " " + rec[1];
            String point2 = rec[0] + " " + rec[3];
            String point3 = rec[2] + " " + rec[3];
            String point4 = rec[2] + " " + rec[1];
            if (!set.add(point1)) set.remove(point1);
            if (!set.add(point2)) set.remove(point2);
            if (!set.add(point3)) set.remove(point3);
            if (!set.add(point4)) set.remove(point4);
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
        }
        if (set.size() != 4 ||!set.contains(r1 + " " + c1) || !set.contains(r1 + " " + c2) || !set.contains(r2 + " " + c1) || !set.contains(r2 + " "+ c2)) return false;
        return area == (r2 - r1) * (c2 - c1);
    }
}
// @lc code=end

