/*
 * @lc app=leetcode id=1048 lang=cpp
 *
 * [1048] Longest String Chain
 */

// @lc code=start
class Solution {
public:
    int longestStrChain(vector<string>& words) {
        unordered_set<string> dict(words.begin(), words.end());
        unordered_map<string, int> map;
        int res = 0;
        for (string word : words) res = max(res, dfs(dict, map, word));
        return res;
    }

private:
    int dfs(unordered_set<string>& dict, unordered_map<string, int>& map, string& word) {
        if (map.count(word)) return map.at(word);
        int res = 0;
        for (int i = 0; i < word.size(); ++i) {
            string prev = word.substr(0, i) + word.substr(i + 1);
            if (dict.count(prev)) res = max(res, dfs(dict, map, prev));
        }
        map[word] = res + 1;
        return res + 1;
    }
};
// @lc code=end

