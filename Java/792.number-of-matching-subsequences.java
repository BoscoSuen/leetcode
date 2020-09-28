/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 */

// @lc code=start
class Solution {
    /*
    利用一个map存储首字母和对应word的序列
    如果当前word只有一个字符并且匹配，count++，否则将substring(1)的对应关系存入map中
    time: O(S + N * L * L)
    space: O(N * L)
    */
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (String word : words) {
            map.putIfAbsent(word.charAt(0), new LinkedList<>());
            map.get(word.charAt(0)).add(word);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (map.containsKey(c)) {
                Deque<String> dq = map.get(c);
                int size = dq.size();
                while (size-- > 0) {
                    String cur = dq.pollFirst();
                    if (cur.length() == 1) {
                        count++;
                    } else {
                        map.putIfAbsent(cur.charAt(1), new LinkedList<>());
                        map.get(cur.charAt(1)).add(cur.substring(1));
                    }
                }
            }
        }
        return count;
    }
}
// @lc code=end

