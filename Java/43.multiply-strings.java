/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
    /*
    num1[i] * num2[j] will be placed at indices [i + j, i + j + 1]
    从后往前按照列竖式的方式相乘

            1   2   3
                4   5
    --------------------------
                1   5
            1   0
        0   5                   mul by 5
    -----------------------
            1   2   
        0   8
    0   4                       mul by 4
    -----------------------
idx 0   1   2   3   4

    time: O(n^2)
    space: O(1)
    */
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[i + j + 1];
                res[i + j] += sum / 10;
                res[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) sb.append(num);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
// @lc code=end

