/*
 * @lc app=leetcode id=451 lang=cpp
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> map;
        priority_queue<pair<int, char>> pq;
        for (char c : s) {
            map[c]++;
        }
        for (auto it : map) {
            pq.push({it.second, it.first});
        }
        string res = "";
        while (!pq.empty()) {
            res += string(pq.top().first, pq.top().second);
            pq.pop();
        }
        return res;
    }
};
// @lc code=end

