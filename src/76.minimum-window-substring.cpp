/*
 * @lc app=leetcode id=76 lang=cpp
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> count(128, 0);
        for (char c : t) {
            count[c]++;
        }
        int min = INT_MAX, left = 0, i = 0, j = 0, num = t.size();  // i: left window, j: right window
        for (; j < s.size(); ++j) {
            if (count[s[j]]-- > 0) --num;
            while (num == 0) {
                if (j - i + 1 < min) {
                    left = i;
                    min = j - i + 1;
                }
                if (++count[s[i++]] > 0) ++ num;
            }
        }
        return min == INT_MAX ? "" : s.substr(left, min);
    }
};
// @lc code=end

