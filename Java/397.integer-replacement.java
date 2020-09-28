/*
 * @lc app=leetcode id=397 lang=java
 *
 * [397] Integer Replacement
 */

// @lc code=start
class Solution {
    /*
    末位为0，除以2
    末位为11，加一， 01则减1
    time: O(bitCount)
    space: O(1)
    */
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if ((((n >>> 1) & 1) == 0) || n == 3) {
                n--;
            } else {
                n++;
            }
            count++;
        }
        return count;
    }
}
// @lc code=end

