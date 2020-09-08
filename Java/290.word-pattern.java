/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
    /*
    time: O(n^2) containsValue() costs O(n)
    space: O(n)
    */
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); ++i) {
            if (map.containsKey(words[i])) {
                if (pattern.charAt(i) != map.get(words[i])) {
                    return false;
                }
            } else if (map.containsValue(pattern.charAt(i))) {
                return false;
            } else {
                map.put(words[i], pattern.charAt(i));
            }
        }
        return true;
    }
}
// @lc code=end

