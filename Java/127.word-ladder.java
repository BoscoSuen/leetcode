/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    /*
    双向bfs, 从begin和end一起做bfs看中间是否相遇, 在每次BFS的时候, 找到size比较小的一边进行bfs(时间优化)
    注意: 双向bfs的两个set不一定会有重复的元素，判断是否路径相连的时候要在bfs内部判断，判断下一层是否有相同元素
    time: O(n * (26^l/2))
    space: O(n)
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) dict.add(word);
        if (!dict.contains(endWord)) return 0;
        Set<String> s1 = new HashSet<>(), s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        int res = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.size() > s2.size()) {
                Set<String> temp = s1;
                s1 = s2;
                s2 = temp;
            }
            Set<String> nextSet = new HashSet<>();
            ++res;
            for (String word : s1) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; ++i) {
                    char c = chs[i];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        if (ch == chs[i]) continue;
                        chs[i] = ch;
                        String next = new String(chs);
                        if (s2.contains(next)) return res + 1;
                        if (!dict.contains(next)) continue;
                        nextSet.add(next);
                        dict.remove(next);
                    }
                    chs[i] = c;
                }
            }
            s1 = nextSet;
        }
        return 0;
    }
}
// @lc code=end

