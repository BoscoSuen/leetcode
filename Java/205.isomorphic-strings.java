/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    /*
    用一个table记录上一次的改字母的位置，数组默认为0，位置记为i + 1
    time: O(n)
    space: O(1)
    */
    public boolean isIsomorphic(String s, String t) {
        int[] sCount = new int[256];
        int[] tCount = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            if (sCount[s.charAt(i)] != tCount[t.charAt(i)]) return false;
            sCount[s.charAt(i)] = i + 1;
            tCount[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
// @lc code=end

