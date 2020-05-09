/*
 * @lc app=leetcode id=1268 lang=cpp
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
/*
binary search,找prefix的lower bound + upper bound
upper bound用"key + ~"来代替(~的ascii > z)
time: sortO(nlogn) queryO(length of words * logn)
space: O(1)
*/
class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        vector<vector<string>>res;
        sort(products.begin(), products.end());
        string prefix = "";
        for (char c : searchWord) {
            prefix += c;
            auto low = lower_bound(products.begin(), products.end(), prefix);
            auto high = upper_bound(products.begin(), products.end(), prefix + '~');
            if (low == high) break;
            res.emplace_back(low, min(low + 3, high));
            // res.push_back(vector<string>(low, min(low + 3, high)));
        }
        while (res.size() < searchWord.size()) res.push_back({});
        return res;
    }
};
// @lc code=end

