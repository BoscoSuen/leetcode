/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    /*
    假设手上最开始只有0元钱，那么如果买入股票的价格为price，手上的钱需要减去这个price，如果卖出股票的价格为price，
    手上的钱需要加上这个price。然后不断更新第一次买，第一次卖，第二次买，第二次卖的钱。
    time: O(n)
    space: O(1)
    */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy1= Integer.MIN_VALUE, buy2= Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}
// @lc code=end

