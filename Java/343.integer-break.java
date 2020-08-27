/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// @lc code=start
class Solution {
/*
 * 从n = 2开始递推，递推到n = 4的时候，4可以拆分成1和3或2和2
 * 那么3要不要继续拆分呢？2要不要继续拆分呢？
 * 不需要。因为我们已经把拆分2或3能得到的最大值分别计算好存在dp[2]和dp[3]了
 * 所以我们只需要比较2和dp[2]、3和dp[3]谁更大就知道要不要继续拆分
 * 所以对每个n，我们只需要考虑拆分成两个数a b的情况，然后看比较a和dp[a]
 * 以及b和dp[b]谁大就用谁相乘，如果dp[a]>a，表示dp[a]继续拆分能得到比不拆分
 * 更大的值，那么就拆分a，对于dp[b]和b也一样
*/
    public int integerBreak(int n) {
        if (n < 2) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}
// @lc code=end

