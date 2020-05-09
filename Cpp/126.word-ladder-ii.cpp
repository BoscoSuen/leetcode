/*
 * @lc app=leetcode id=126 lang=cpp
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    /*
    bfs + dfs, 用一个map来存其中的string对应的parent的路径，bfs找到最短路径时，倒序进行dfs
    time: O(n * 26^l)   l = len of word, n = |wordlist|
    space:O(n + k * l)  k = num of paths
    */
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> dict(wordList.begin(), wordList.end());        
        if (!dict.count(endWord)) return {};
        dict.erase(beginWord);
        dict.erase(endWord);
        
        unordered_map<string, int> steps{{beginWord, 1}};
        unordered_map<string, vector<string>> parents;
        queue<string> q;
        q.push(beginWord);
        
        vector<vector<string>> ans;
        
        const int l = beginWord.length();
        int step = 0;        
        bool found = false;
        
        while (!q.empty() && !found) {
            ++step;            
            for (int size = q.size(); size > 0; size--) {
                const string p = q.front(); q.pop();
                string w = p;
                for (int i = 0; i < l; i++) {
                    const char ch = w[i];
                    for (int j = 'a'; j <= 'z'; j++) {
                        if (j == ch) continue;
                        w[i] = j;
                        if (w == endWord) {
                            parents[w].push_back(p);
                            found = true;
                        } else {
                            // Not a new word, but another transform
                            // with the same number of steps
                            if (steps.count(w) && step < steps.at(w))
                                parents[w].push_back(p);
                        }
                        
                        if (!dict.count(w)) continue;
                        dict.erase(w);
                        q.push(w);
                        steps[w] = steps.at(p) + 1;
                        parents[w].push_back(p);
                    }
                    w[i] = ch;
                }
            }
        }
        
        if (found) {
            vector<string> curr{endWord};
            getPaths(endWord, beginWord, parents, curr, ans);
        }
    
        return ans;
    }
private:
    void getPaths(const string& word, 
                  const string& beginWord, 
                  const unordered_map<string, vector<string>>& parents,
                  vector<string>& curr,
                  vector<vector<string>>& ans) {        
        
        if (word == beginWord) {
            ans.push_back(vector<string>(curr.rbegin(), curr.rend()));
            return;
        }
        
        for (const string& p : parents.at(word)) {
            curr.push_back(p);
            getPaths(p, beginWord, parents, curr, ans);
            curr.pop_back();
        }        
    }
};
// @lc code=end

