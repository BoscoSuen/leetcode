/*
 * @lc app=leetcode id=722 lang=java
 *
 * [722] Remove Comments
 */

// @lc code=start
class Solution {
    /*
    time: O(number of chars)
    space: O(numbe of chars)
    */
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        if (source == null || source.length == 0) return res;
        StringBuilder sb = new StringBuilder();
        boolean inComment = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); ++i) {
                if (inComment) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        i++;
                        inComment = false;
                    }
                } else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        i++;
                        inComment = true;
                    } else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!inComment && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
// @lc code=end

