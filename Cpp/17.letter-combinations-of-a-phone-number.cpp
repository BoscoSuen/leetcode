/*
 * @lc app=leetcode id=17 lang=cpp
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        if(digits.empty()) return res;
        vector<string> dict({"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"});
        string cur = "";
        dfs(digits, cur, dict, res, 0);
        return res;
    }

private:
    void dfs(string digits, string& cur, vector<string>& dict, vector<string>& res, int pos) {
        if (pos == digits.size()) {
            res.push_back(cur);
            return;
        }
        for (auto c : dict[digits[pos] - '0']) {
            cur.push_back(c);
            dfs(digits, cur, dict, res, pos + 1);
            cur.pop_back();
        }
    }
};
// @lc code=end

