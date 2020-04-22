/*
 * @lc app=leetcode id=846 lang=cpp
 *
 * [846] Hand of Straights
 */

// @lc code=start
class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int W) {
        if (hand.size() % W != 0) return false;
        map<int, int> map;
        for (int h : hand) map[h]++;
        while (map.size()) {
            int start = map.begin()->first;
            for (int i = 0; i < W; ++i) {
                if (!map.count(start + i)) return false;
                if (--map[start + i] == 0) map.erase(start + i);
            }
        }
        return true;
    }
};
// @lc code=end

