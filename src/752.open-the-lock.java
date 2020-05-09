/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add("0000");
        end.add(target);
        int step = 0;
        Set<String> temp;
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                temp = end;
                end = begin;
                begin = temp;
            }
            Set<String> nextSet = new HashSet<>();
            for (String str : begin) {
                if (end.contains(str)) return step;
                if (deads.contains(str)) continue;
                StringBuilder sb = new StringBuilder(str);
                deads.add(str);
                for (int i = 0; i < 4; ++i) {
                    char c = str.charAt(i);
                    String next1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String next2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!deads.contains(next1)) nextSet.add(next1);
                    if (!deads.contains(next2)) nextSet.add(next2);
                }
            }
            begin = nextSet;
            step++;
        }
        return -1;
    }
}
// @lc code=end

