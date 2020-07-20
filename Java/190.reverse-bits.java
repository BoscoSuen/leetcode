/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    /*
    n = 10111
    从res = 0, 对于每一位, 拿出n的最后一位n & 1, 加到res的最后一位
    0 << 1 + (n & 1) -> 1       n >> 1
    1 << 1 + (n & 1) -> 11
    10 << 1 + (n & 1) -> 111 ... -> 1110 -> 11101
    */
    public int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
// @lc code=end

