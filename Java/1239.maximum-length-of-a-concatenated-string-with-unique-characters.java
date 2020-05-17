/*
 * @lc app=leetcode id=1239 lang=java
 *
 * [1239] Maximum Length of a Concatenated String with Unique Characters
 */

// @lc code=start
class Solution {
    /*
    用bit and 来记录是否有duplicate char, 用bit or 来记录concatinate
    对于一个string, 本身有dup就跳过，否则就和已经concatinate过的bit mask看有没有更长的bit or
    最后用Integer.bitCount返回最长长度
    time: O(2^n) combination: arr use or not
    time: O(2^n)
    */
    public int maxLength(List<String> arr) {
        List<Integer> mask = new ArrayList<>();
        int max = 0;
        mask.add(0);
        for (String s : arr) {
            int dup = 0, cur = 0;
            for (char c : s.toCharArray()) {
                dup |= cur & (1 << (c - 'a'));
                cur |= 1 << (c - 'a');
            }
            if (dup > 0) continue;
            for (int i = 0; i < mask.size(); ++i) {
                if ((mask.get(i) & cur) > 0) continue;
                int comb = mask.get(i) | cur;
                mask.add(comb);
                max = Math.max(max, Integer.bitCount(comb));
            }
        }
        return max;
    }
}
// @lc code=end

