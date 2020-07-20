/*
 * @lc app=leetcode id=837 lang=java
 *
 * [837] New 21 Game
 */

// @lc code=start

/*
条件概率：dp[i]表示可以到达i分数的概率总和。假设我们的K为10的话，抽到每张牌的概率都是1/10。那么我们只需要从dp[i-10]  
开始加就可以了，所以就是维持一个size为K的window。比如12这个数，我们可以由抽到2的概率（dp[2]）乘以1/10或者抽到3的概率（dp[3]）
乘以1/10得来...一直到dp[11] * 1/10，那么把他们相加就是可以到达point i的总概率了（就是dp[i]的值）。相当于是最基本的条件概率。
那么总概率就是 dp[12] = dp[2] * 1/10 + dp[3] * 1/10 + dp[4] * 1/10 + ... + dp[11] * 1/10.
再详细剖析：因为从2到11这10个数都有可能通过只抽一张牌就到达12分。以此类推，只要是point没到K，之前的数都有可能到达当前的数，size超过K的时候，
我们就维持一个size为K的window，再通过条件概率的公式累加和就可以了。

现在我们已经有公式 dp[i] = dp[1] * 1/W + dp[2] * 1/W + dp[3] * 1/W + ... dp[i-2] * 1/W + dp[i-1] * 1/W，
通过这个公式，我们可以换算成 (dp[1] + dp[2] + ... + dp[i - 1]) / W，这里的dp[1] + dp[2] + ... + dp[i - 1] 就是Wsum，所以dp[i] = Wsum / W。
换句话来说Wsum就是通过一次抽排就能到当前分数的概率之和。当然，我们这个example公式的Wsum是当i没有超过W时候的值，
 如果i超过了W，那就不是从dp[1]开始加了，而是从dp[i - W]开始加，相当于向右挪动window， 最多只能是从point i - W
开始才能通过只抽一张牌就到达point i
time: O(n)
space: O(n)
*/
class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1.0;
        double[] dp = new double[N + 1];
        double wSum = 1.0;  
        double res = 0;
        dp[0] = 1.0; // 如果第一张不能抽时，把初始的1.0的wSum减掉
        for (int i = 1; i <= N; ++i) {
            dp[i] = wSum / W;
            if (i < K) {
                wSum += dp[i];  // dp[i]的基础上还能再抽
            } else {
                res += dp[i]; 
            }
            if (i >= W) {
                wSum -= dp[i - W];
            }
        }
        return res;
    }
}
// @lc code=end

