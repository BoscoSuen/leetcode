/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    /*
    dfs+memo
    time: O(n^3) Size of recursion tree can go up to n^2. The creation of list takes n time.
    space: O(n^2)
    */
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, dict);
    }

    private List<String> dfs(String s, Set<String> dict) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        if (dict.contains(s)) res.add(s);
        for (int i = 1; i < s.length(); ++i) {
            String left = s.substring(0, i);
            if (!dict.contains(left)) continue;
            List<String> rightPart = dfs(s.substring(i), dict);
            for (String right : rightPart) {
                res.add(left + " " + right);
            }
        }
        map.put(s, res);
        return res;
    }
}
// @lc code=end

