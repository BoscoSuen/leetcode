/*
 * @lc app=leetcode id=1048 lang=java
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
    /*
    dfs + memorization
    利用一个map来存储以word为结尾的最长chain, prev word为当前word删除一个字符
    如果prev word在words中，则进行下一层dfs,如果map中有记录就直接返回
    time: O(n * k^2) n: length of words, k: average length of word, including the for loop and substring
    space: O(n)
    */
    public int longestStrChain(String[] words) {
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (String word : dict) res = Math.max(res, dfs(dict, map, word));
        return res;
    }

    private int dfs(Set<String> dict, Map<String, Integer> map, String word) {
        if (map.containsKey(word)) return map.get(word);
        int max = 0;
        for (int i = 0; i < word.length(); ++i) {
            String prev = word.substring(0, i) + word.substring(i + 1);
            if (dict.contains(prev)) {
                max = Math.max(max, dfs(dict, map, prev));
            }
        }
        map.put(word, max + 1);
        return max + 1;
    }
}
// @lc code=end

