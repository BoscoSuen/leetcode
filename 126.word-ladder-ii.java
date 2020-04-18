/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    /*
    双向BFS, 利用一个children map记录当前string对应的path中的下一位, 然后用reverse bool来判断是否需要把parent和child进行调换
    注意: 每次bfs之前需要把已经遍历的两端中的word从dict中删除
    time: O(n * 26^l/2) n: len of wordList, l: length of the word
    space: O(n + k * l) k : num of paths
    */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);
        if (!dict.contains(endWord)) return res;
        dict.remove(beginWord);
        dict.remove(endWord);
        Set<String> begin = new HashSet<>();   begin.add(beginWord);
        Set<String> end = new HashSet<>();     end.add(endWord);
        Map<String, List<String>> children = new HashMap<>();
        boolean found = false;
        boolean reverse = false;
        while (!begin.isEmpty() && !end.isEmpty() && !found) {
            if (begin.size() > end.size()) {
                reverse = !reverse;
                Set<String> temp = end;
                end = begin;
                begin = temp;
            }
            dict.removeAll(begin);
            dict.removeAll(end);
            Set<String> nextSet = new HashSet<>();
            for (String p : begin) {
                String cur = p;
                char[] chs = cur.toCharArray();
                for (int i = 0; i < cur.length(); ++i) {
                    char c = chs[i];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        if (chs[i] == ch) continue;
                        chs[i] = ch;
                        String next = new String(chs);
                        String parent = p;
                        String child = next;
                        if (reverse) {
                            String temp = child;
                            child = parent;
                            parent = temp;
                        }
                        if (end.contains(next)) {
                            found = true;
                            if (!children.containsKey(parent)) children.put(parent, new ArrayList<>());
                            children.get(parent).add(child);
                        } else if (!found && dict.contains(next)) {
                            nextSet.add(next);
                            if (!children.containsKey(parent)) children.put(parent, new ArrayList<>());
                            children.get(parent).add(child);
                        }
                    }
                    chs[i] = c;
                }
            }
            begin = nextSet;
        }
        if (!found) return res;
        List<String> cur = new ArrayList<>(); cur.add(beginWord);
        dfs(res, cur, beginWord, endWord, children);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> cur, String word, String endWord, Map<String, List<String>> children) {
        if (word.equals(endWord)) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (!children.containsKey(word)) return;
        for (String str : children.get(word)) {
            cur.add(str);
            dfs(res, cur, str, endWord, children);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

