/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    /*
    sliding window + hashmap存对应p中字符的counter
    time: O(Ns + Np)
    space: O(1)  most 26 chars
    */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        int begin = 0, end = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) count--;
            }
            end++;
            while (count == 0) {
                char c = s.charAt(begin);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) count++;
                }
                if (end - begin == p.length()) res.add(begin);
                begin++;
            }
        }
        return res;
    }
}
// @lc code=end

