/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    /*
如果k >= prices.length / 2, 则视为可以无限次交易
我们定义local[i][j]为在到达第i天时最多可进行j次交易并且最后一次交易在最后一天卖出的最大利润，此为局部最优。然后我们定义global[i][j]为在到达第i天时最多可进行j次交易的最大利润，此为全局最优。它们的递推式为：
local[i][j] = max(global[i - 1][j - 1] + max(diff, 0), local[i - 1][j] + diff)
global[i][j] = max(local[i][j], global[i - 1][j])
time: O(kn)
space: O(k)
    */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        if (k >= prices.length / 2) return unlimitedProfit(prices);
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 0; i < prices.length - 1; ++i) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; --j) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }
    
    private int unlimitedProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i + 1] - prices[i] > 0) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}
// @lc code=end

