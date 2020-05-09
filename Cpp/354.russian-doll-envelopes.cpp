/*
 * @lc app=leetcode id=354 lang=cpp
 *
 * [354] Russian Doll Envelopes
 */

// @lc code=start
class Solution {
public:
    static bool comparator(vector<int>& v1, vector<int>& v2) {
        return v1[0] == v2[0] ? v2[1] < v1[1] : v1[0] < v2[0];
    }
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        if (!envelopes.size()) return 0;
        sort(envelopes.begin(), envelopes.end(), comparator);
        int n = envelopes.size();
        vector<int> tails(n, 0);
        int res = 0;
        for (int i = 0; i < envelopes.size(); ++i) {
            int left = 0, right = res;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (tails[mid] >= envelopes[i][1]) {
                    right = mid;
                } else left = mid + 1;
            }
            tails[left] = envelopes[i][1];
            if (left == res) ++res;
        }
        return res;
    }
};
// @lc code=end

