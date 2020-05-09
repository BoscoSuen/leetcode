/*
 * @lc app=leetcode id=5 lang=cpp
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
/*
manacher's algo: https://github.com/Yukinichi/leetcode/blob/master/Note/Manacher_Algorithm.md
time:O(n)
space: O(n)
*/
public:
    string longestPalindrome(string s) {
        if (s.size() < 2) return s;
        string p = "^";
        for (auto c : s) {
            p += "#";
            p += c;
        }
        p += "#$";
        vector<int> dp(p.size(), 0);
        int center = 0, r = 0;  // r: center对应最长回文右边界
        for (int i = 1; i < p.size() - 1; ++i) {
            int i_m = 2 * center - i;
            dp[i] = r >= i ? min(r - i, dp[i_m]) : 0;
            while (p[i + dp[i] + 1] == p[i - dp[i] - 1]) { dp[i]++; }
            if (i + dp[i] > r) {
                center = i;
                r = i + dp[i];
            }
        }
        center = max_element(dp.begin(), dp.end()) - dp.begin();
        return s.substr((center - dp[center]) / 2, dp[center]);
    }
};
// @lc code=end

