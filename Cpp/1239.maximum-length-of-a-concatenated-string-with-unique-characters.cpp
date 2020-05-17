/*
 * @lc app=leetcode id=1239 lang=cpp
 *
 * [1239] Maximum Length of a Concatenated String with Unique Characters
 */

// @lc code=start
class Solution {
public:
    int maxLength(vector<string>& arr) {
        int res = 0;
        vector<bitset<26>> mask = {bitset<26>()};
        for (auto& s : arr) {
            bitset<26> a;
            for (char c : s) {
                a.set(c - 'a');
            }
            if (a.count() < s.size()) continue;
            for (int i = 0; i < mask.size(); ++i) {
                bitset c = mask[i];
                if ((c & a).any()) continue;
                mask.push_back(c | a);
                int len = c.count() + a.count();
                res = max(res, len);
            }
        }
        return res;
    }
};
// @lc code=end

