/*
 * @lc app=leetcode id=824 lang=java
 *
 * [824] Goat Latin
 */

// @lc code=start
class Solution {
    public String toGoatLatin(String S) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String[] strs = S.split(" ");
        StringBuilder[] sbs = new StringBuilder[strs.length];
        for (int i = 0; i < sbs.length; ++i) {
            sbs[i] = new StringBuilder();
        }
        for (int i = 0; i < sbs.length; ++i) {
            if (set.contains(strs[i].charAt(0))) {
                sbs[i].append(strs[i]);
            } else {
                sbs[i].append(strs[i].substring(1)).append(strs[i].charAt(0));
            }
            sbs[i].append("ma");
            for (int j = 0; j <= i; ++j) {
                sbs[i].append("a");
            }
        }
        for (int i = 1; i < sbs.length; ++i) {
            sbs[0].append(" ").append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
// @lc code=end

