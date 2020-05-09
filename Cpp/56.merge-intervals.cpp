/*
 * @lc app=leetcode id=56 lang=cpp
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
public:
    static bool comparator(vector<int>& v1, vector<int>& v2) {
        return v1[0] < v2[0];
    }
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if (intervals.empty() || intervals.size() < 2) return intervals;
        vector<vector<int>> res;
        sort(intervals.begin(), intervals.end(), comparator);
        res.push_back(intervals[0]);
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals[i][0] <= res.back()[1]) res.back()[1] = max(res.back()[1], intervals[i][1]);
            else res.push_back(intervals[i]);
        }
        return res;
    }
};
// @lc code=end

