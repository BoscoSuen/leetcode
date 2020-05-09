/*
 * @lc app=leetcode id=476 lang=java
 *
 * [476] Number Complement
 */

// @lc code=start
class Solution {
    /*
    11001 complement 00110
    用11111 - num
    11111: Integer.highestOneBit(num) << 1) - 1
    */
    public int findComplement(int num) {
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }
}
// @lc code=end

