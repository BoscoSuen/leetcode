/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
class Solution {
    /*
    dfs + backtracking, 注意valid包括ip分为了4部分，要加上count
    time: O(3^4) 最多递归4层
    space: O(1)
    */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, s, new StringBuilder(), 0, 0);
        return res;
    }

    private void dfs(List<String> res, String s, StringBuilder sb, int pos, int count) {
        if (count > 4) return;
        if (pos == s.length() && count == 4) {
            res.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3 && pos + i <= s.length(); ++i) {
            String cur = s.substring(pos, pos + i);
            if (Integer.valueOf(cur) > 255 || cur.length() > 1 && cur.charAt(0) == '0') break;
            int len = sb.length();
            dfs(res, s, sb.append(cur).append(count == 3 ? "" : "."), pos + i, count + 1);
            sb.setLength(len);
        }
    }
}
// @lc code=end

