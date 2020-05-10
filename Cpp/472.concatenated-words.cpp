/*
 * @lc app=leetcode id=472 lang=cpp
 *
 * [472] Concatenated Words
 */

// @lc code=start
class Solution {
/*
dfs + memo
time without memo: O(N*L^2 * 2^L)
*/

public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        vector<string> res;
        unordered_set<string> dict(words.begin(), words.end());
        for (string word : words) {
            if (dfs(dict, word, 0)) res.push_back(word);
        }
        return res;
    }

private:
    bool dfs(unordered_set<string>& dict, string& word, int count) {
        if (dict.count(word) && count > 1) return true;
        // only break word in the middle
        for (int i = 1; i < word.size(); ++i) {
            string left = word.substr(0, i);
            if (!dict.count(left)) continue;
            string right = word.substr(i);
            if (dict.count(right) || dfs(dict, right, count + 1)) return true;
        }
        return false;
    }
};

/*
optimize: dfs + memo
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        vector<string> res;
        unordered_set<string> dict(words.begin(), words.end());
        unordered_map<string, bool> memo;
        for (string word : words) {
            if (dfs(dict, word, memo)) res.push_back(word);
        }
        return res;
    }

private:
    bool dfs(unordered_set<string>& dict, string& word, unordered_map<string, bool>& memo) {
        if (memo.count(word)) return memo.at(word);
        // only break word in the middle
        for (int i = 1; i < word.size(); ++i) {
            if (dict.count(word.substr(0, i))) {
                string right = word.substr(i);
                if (dict.count(right) || dfs(dict, right, memo)) {
                    memo[word] = true;
                    return true;
                }
            }
        }
        memo[word] = false;
        return false;
    }
};
*/
// @lc code=end

