/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    /*
    greedy: 记录每个字母最后一次出现的位置last
    遍历S,如果当前最大的last index = current index,说明当前part符合条件,可以开一个新的part
    time: O(n)
    space: O(1)
    */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); ++i) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
// @lc code=end

