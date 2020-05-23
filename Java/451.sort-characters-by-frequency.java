/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    /*
    bucket sort
    get frequency and use a List<Character>[] bucket to store the char at corresponding bucket
    time: O(n)
    space: O(n)
    */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; --i) {
            if (bucket[i] == null) continue;
            else for (char c : bucket[i]) {
                for (int j = 0; j < i; ++j) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

