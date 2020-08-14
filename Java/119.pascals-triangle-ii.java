/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    /*
    按位置修改元素为对应位置的和，最后再开头补1
    time: O(k)
    space: O(k)
    */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0) return res;
        while (rowIndex-- > 0) {
            for (int i = 1; i < res.size(); ++i) {
                res.set(i - 1, res.get(i - 1) + res.get(i));
            }
            res.add(0, 1);
        }
        return res;
    }
}
// @lc code=end

