/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    /*
    找到能整除的substring长度，复制substring然后和s做比较
    time: O(n^2)
    sapce: O(n)
    */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i > 0; --i) {
            if (n % i != 0) continue;
            int num = n / i;
            String str = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            while (num-- > 0) {
                sb.append(str);
            }
            if (sb.toString().equals(s)) return true;
        }
        return false;
    }
}
// @lc code=end

