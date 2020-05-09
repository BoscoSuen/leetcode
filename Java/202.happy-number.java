/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    /*
    This problem is based on the intuition that you will get repeated numbers again and again if 1 is not going to come eventually
    So it is converted to cycle detection
    Floyd Cycle Detection: 慢指针+两步的快指针
    Brent's Cycle Detection: https://www.cnblogs.com/hyserendipity/p/8280725.html
    起始令乌龟兔子指向起始节点，让乌龟保持不动，兔子走2^i 步， 即迭代一次，兔子走2步， 迭代2次，兔子走4步等等。
    在兔子走每一步后，判断龟兔是否相遇，如果没有相遇，则让乌龟的位置变成兔子所在的位置，否则如果乌龟不动，则乌龟永远无法进入环内，随后进入新的迭代。循环下去，直至相遇或到表尾。
    time: O(n)
    */
    public boolean isHappy(int n) {
        int tortoise = 0, hare = n;
        int step = 0, power = 2;
        while (hare != 1 && tortoise != hare) {
            // tortoise == hare: get cycle, hare = 1: happy number
            if (step == power) {
                tortoise = hare;
                power *= 2;
                step = 0;
            }
            step++;
            hare = getSquareSum(hare);
        }
        return hare == 1;
    }

    private int getSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
// @lc code=end

