/*
 * @lc app=leetcode id=1297 lang=java
 *
 * [1297] Maximum Number of Occurrences of a Substring
 */

// @lc code=start
class Solution {
    /*
    最多重复的window一定是minSize window，更大的window只会减少重复次数
    time: O(minsize * n)
    space: O(minsize * n)
    */
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int count = 0;
        int[] letters = new int[256];
        Map<String, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            if (letters[s.charAt(end++)]++ == 0) {
                count++;
            }
            while (count > maxLetters || end - start > minSize) {
                if (letters[s.charAt(start++)]-- == 1) {
                    count--;
                }
            }
            if (end - start == minSize) {
                String cur = s.substring(start, end);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                res = Math.max(res, map.get(cur));
            }
        }
        return res;
    }
}
// @lc code=end

