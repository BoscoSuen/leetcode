/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        String cur = "1";
        while (n-- - 1 > 0) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char c = cur.charAt(0);
            for (int i = 0; i <= cur.length(); ++i) {
                if (i < cur.length() && cur.charAt(i) == c) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    if (i < cur.length()) {
                        count = 1;
                        c = cur.charAt(i);
                    }
                }
            }
            cur = sb.toString();
        }
        return cur;
    }
}
// @lc code=end

