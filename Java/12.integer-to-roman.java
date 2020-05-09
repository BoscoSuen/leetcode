/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
    /*
    对数组中从大到小的数字进行--操作，然后转化成相对应的罗马字符
    time: O(1) values has constant length and num will reach to < values[i] in constant time
    space: O(n)
    */
    public String intToRoman(int num) {
        if (num < 1) return "";
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roms = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(roms[i]);
            }
        }
        return res.toString();
    }
}
// @lc code=end

