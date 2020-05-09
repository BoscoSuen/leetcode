/*
 * @lc app=leetcode id=939 lang=cpp
 *
 * [939] Minimum Area Rectangle
 */

// @lc code=start
class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        if (points.empty()) return 0;
        unordered_map<int, unordered_set<int>> map;
        for (auto& point : points) {
            map[point[0]].insert(point[1]);
        }
        int res = INT_MAX;
        for (int i = 0; i < points.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (i == j || points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                if (map.at(points[i][0]).count(points[j][1]) && map.at(points[j][0]).count(points[i][1])) {
                    res = min(res, abs((points[i][0] - points[j][0]) * (points[i][1] - points[j][1])));
                }
            }
        }
        return res == INT_MAX ? 0 : res;
    }
};
// @lc code=end

