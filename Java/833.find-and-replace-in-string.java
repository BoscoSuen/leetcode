/*
 * @lc app=leetcode id=833 lang=java
 *
 * [833] Find And Replace in String
 */

// @lc code=start
class Solution {
    /*
    为了不使后面的字符串影响, index从后往前replace
    time: O(nlogn + n * s)  s: length of word
    space: O(n)
    */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < indexes.length; ++i) {
            pq.offer(new int[]{indexes[i], i});
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            String s = sources[cur[1]];
            String t = targets[cur[1]];
            int i = cur[0];
            if (S.substring(i, i + s.length()).equals(s)) {
                S = S.substring(0, i) + t + S.substring(i + s.length());
            }
        }
        return S;
    }
}
// @lc code=end

