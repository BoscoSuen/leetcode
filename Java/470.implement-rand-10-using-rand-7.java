/*
 * @lc app=leetcode id=470 lang=java
 *
 * [470] Implement Rand10() Using Rand7()
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    /*
rand7() will get random 1 ~ 7
(rand7() - 1) * 7 + rand7() - 1 will get random 0 ~ 48
We discard 40 ~ 48, now we have rand40 equals to random 0 ~ 39.
We just need to return rand40 % 10 + 1 and we get random 1 ~ 10.

In 9/49 cases, we need to start over again.
In 40/49 cases, we call rand7() two times.

Overall, we need 49/40*2 = 2.45 calls of rand7() per rand10().
    */
    public int rand10() {
        int rand40 = 40;
        while (rand40 >= 40) {
            rand40 = (rand7() - 1) * 7 + (rand7() - 1);
        }
        return rand40 % 10 + 1;
    }
}
// @lc code=end

