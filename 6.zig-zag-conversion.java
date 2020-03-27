/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    /*
    find the row index for the corrsponding row
    time: O(n)
    space: O(n)
    */
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; ++i) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); ++i) {
            int temp = i % (2 * numRows - 2);
            int row = temp < numRows ? temp : (numRows - 1 - (temp - numRows + 1));
            sb[row].append(s.charAt(i));
        }
        for (int i = 1; i < sb.length; ++i) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
// @lc code=end

