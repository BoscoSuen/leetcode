/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    /*
    sliding window + hashmap, template same as leetcode 438
    time: O(mn)
    space: O(1)
    */
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() == 0) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        int begin = 0, end = 0;
        char[] chs = s2.toCharArray();
        while (end < chs.length) {
            if (map.containsKey(chs[end])) {
                map.put(chs[end], map.get(chs[end]) - 1);
                if (map.get(chs[end]) == 0) count--;
            }
            end++;
            while (count == 0) {
                if (map.containsKey(chs[begin])) {
                    if (end - begin == s1.length()) return true;
                    map.put(chs[begin], map.get(chs[begin]) + 1);
                    if (map.get(chs[begin]) > 0) {
                        count++;
                    }
                }
                begin++;
            }
        }
        return false;
    }
}
// @lc code=end

