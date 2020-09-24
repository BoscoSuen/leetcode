/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */

// @lc code=start
class Solution {
    /*
    dfs 因为有乘除运算，除了要传入目前的计算结果，还需要传入prev值做乘法运算
    注意0开头的数字除了0都是invalid
    time: O(n*4^n)
T(n) = 3 * T(n-1) + 3 * T(n-2) + 3 * T(n-3) + ... + 3 *T(1);
T(n-1) = 3 * T(n-2) + 3 * T(n-3) + ... 3 * T(1);
Thus T(n) = 4T(n-1);
times substring O(n) --> O(n*4^n)
    space: O(n)
    */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), num, target, 0, 0, 0);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder sb, String num, int target, int pos, long val, long prev) {
        if (pos == num.length()) {
            if (val == target) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = pos; i < num.length(); ++i) {
            if (num.charAt(pos) == '0' && i != pos) break;
            Long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if (pos == 0) {
                dfs(res, sb.append(cur), num, target, i + 1, val + cur, cur);
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(cur), num, target, i + 1, val + cur, cur);
                sb.setLength(len);
                dfs(res, sb.append("-").append(cur), num, target, i + 1, val - cur, -cur);
                sb.setLength(len);
                dfs(res, sb.append("*").append(cur), num, target, i + 1, val - prev + prev * cur, prev * cur);
                sb.setLength(len);
            }
        }
    }
}
// @lc code=end

