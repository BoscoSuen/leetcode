/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start
class Solution {
    /*
    "." 和"|"都是转义字符，需要加\\才能分割
    time:O(n)
    space: O(n)
    */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = j < v2.length ? Integer.parseInt(v2[j]) : 0;
            if (num1 != num2) {
                return num1 < num2 ? -1 : 1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
// @lc code=end

