/*
 * @lc app=leetcode id=127 lang=cpp
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (dict.find(endWord) == dict.end()) return 0;
        int res = 0;
        unordered_set<string> s1, s2, *small, *large;
        s1.insert(beginWord);
        s2.insert(endWord);
        while (!s1.empty() && !s2.empty()) {
            ++res;
            small = s1.size() > s2.size() ? &s2 : &s1;
            large = s1.size() > s2.size() ? &s1 : &s2;
            unordered_set<string> nextSet;
            for (auto& word : *small) {
                string cur(word);
                for (int i = 0; i < cur.size(); ++i) {
                    char c = cur[i];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        cur[i] = ch;
                        if (large->find(cur) != large->end()) return res + 1;
                        if (dict.find(cur) == dict.end()) continue;
                        nextSet.insert(cur);
                        dict.erase(cur);
                    }
                    cur[i] = c;
                }
            }
            swap(*small, nextSet);
        }
        return 0;
    }
};
// @lc code=end

