/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
            }
            --i;
            --j;
            sb.append(sum % 10);
            sum /= 10;
        }
        if (sum > 0) sb.append(sum);
        return sb.reverse().toString();
    }
}
// @lc code=end

