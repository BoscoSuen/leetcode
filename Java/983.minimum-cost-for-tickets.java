/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }
        int[] dp = new int[366];
        for (int i = 1; i <= 365; ++i) {
            if (!set.contains(i)) dp[i] = dp[i - 1];
            else {
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
            }
        }
        return dp[365];
    }
}
// @lc code=end

