/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
/*
在过程中sold到buy之间要经历rest过程，rest期间可以继续rest也可以buy，
hold期间可以继续持有股票也可以卖出(sold的结果是在第二天获得收益)
最后在输出的过程中，由于rest是要晚一天，其中也没有buy的操作，也有可能会有最大利润，
所以在输出的时候要比较最后的rest和sold.
time: O(n)
space: O(1)
*/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int sold = 0;  //卖出后的收益
        int rest = 0;  // 不交易状态下的收益
        int hold = Integer.MIN_VALUE; //持有的收益(未买入时持有为当前最小值)
        for (int price : prices) {
            int preSold = sold;  // 保存上一状态下的sold
            sold = hold + price;
            hold = Math.max(hold, rest - price);  //相较上次可以是保持，也可以是买入后的持有
            rest = Math.max(rest, preSold);  //可以休息可以是之前卖出后的收益
        }
        return Math.max(rest,sold);  //rest比sold慢一天，最后输出时两个结果都要比较
    }
}
// @lc code=end

