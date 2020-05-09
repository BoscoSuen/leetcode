/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    /*
    Sliding window:
    统计T串中字母的个数，而不是仅仅看某个字母是否在T串中出现。统计好T串中字母的个数了之后，我们开始遍历S串，对于S中的每个遍历到的字母，
    都在 count[] 中的映射值减1，如果减1后的映射值仍大于等于0，说明当前遍历到的字母是T串中的字母，我们使用一个计数器 num，使其自增1。
    当 num 和T串字母个数相等时，说明此时的窗口已经包含了T串中的所有字母，此时更新一个 minLen 和结果 res，这里的 minLen 是我们维护的一个全局变量，
    用来记录出现过的包含T串所有字母的最短的子串的长度，结果 res 
    cnt 值就要减1了，然后移动左边界 left。
    步骤如下：
    - 我们最开始先扫描一遍T，把对应的字符及其出现的次数存到 count[] 中。
    - 然后开始遍历S，就把遍历到的字母对应的 count[] 中的 次数 减一，如果减1后仍大于等于0，num 自增1。
    - 如果 num 等于T串长度时，开始循环，纪录一个字串并更新最小字串值。然后将子窗口的左边界向右移，如果某个移除掉的字母是T串中不可缺少的字母，那么 num 自减1，表示此时T串并没有完全匹配。
    * : 将count设为256个字符的数组，可直接count[char]代表对应的字符
    time: O(n)
    space: O(1)
    */
    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0) return "";
        int[] count = new int[256];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int num = t.length();
        for (int i = 0, j = 0; j < s.length();++j) {
            // i: left window, j: right window
            if (count[s.charAt(j)]-- > 0) {
                --num;
            }
            while (num == 0) {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    start = i;
                }
                if (++count[s.charAt(i++)] > 0) num++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
// @lc code=end

