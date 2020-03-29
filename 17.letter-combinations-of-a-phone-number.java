/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    存储每个数字对应的字符串，然后dfs
    time:O(4^n)
    space: O(n)
    */
    Map<Integer,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        helper(res, digits, new StringBuilder(), 0);
        return res;
    }

    private void helper(List<String> res, String digits, StringBuilder sb, int pos) {
        if (pos == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int length = sb.length();
        String cur = map.get(digits.charAt(pos) - '0');
        for (int i = 0; i < cur.length(); ++i) {
            sb.append(cur.charAt(i));
            helper(res,digits,sb,pos + 1);
            sb.setLength(length);
        }
    }
}
// @lc code=end

