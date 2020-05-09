/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
/*
先用map存储对应count, 再Collections.sort, override comparator
time: O(nlogn)
space: O(n)
*/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> ((a.equals(b) || map.get(a) == map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a)));
        return list.subList(0, k);
    }
}
// @lc code=end

