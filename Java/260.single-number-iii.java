/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start
class Solution {
    /*
    constant space解: 假设答案是a, b
    xor所有数，得到cur = (a ^ b)，
    利用cur = cur & (-cur)得到某一位置a和b的数不相同
    重新遍历，如果和cur &为0放到一组，其中有a,其余的被抵消掉
    和cur &为1的放到另一组，其中有b,其余的被抵消掉
    time: O(n)
    space: O(1)
    */
    public int[] singleNumber(int[] nums) {
        int cur = 0;
        for (int num : nums) {
            cur ^= num;
        }
        cur &= -cur;
        int[] res = new int[]{0, 0};
        for (int num : nums) {
            if ((num & cur) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
// @lc code=end

