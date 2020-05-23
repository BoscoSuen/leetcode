/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    /*
    如果一个数组的总和非负，那么一定可以找到一个起始位置，从他开始绕数组一圈，累加和一直都是非负的
    现在突然发现开往位置j时油箱空了。这说明什么？说明从位置i开始没法走完全程。那么，我们不需要从位置i+1开始重新尝试
    因为前面已经知道，位置i肯定是正积累，那么，如果从位置i+1开始走更加没法走完全程了，因为没有位置i的正积累了。
    同理，也不用从i+2，i+3，...开始尝试。所以我们可以放心地从位置j+1开始尝试。
    time :O(n)
    space: O(1)
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; ++i) {
            total += gas[i] - cost[i];
            if (sum < 0) {
                start = i;
                sum = gas[i] - cost[i];
            } else {
                sum += gas[i] - cost[i];
            }
        }
        return total >= 0 ? start : -1;
    }
}
// @lc code=end

