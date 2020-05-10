/*
 * @lc app=leetcode id=472 lang=java
 *
 * [472] Concatenated Words
 */

// @lc code=start
class Solution {
    /*
    trie + dfs, dfs递归用isword + sub dfs返回boolean
    time: build tree: O(n * len of word), query: O(N * 2^L * L)
    as for query time complexity: O(L) to loop through word, in sub dfs: 
    time = O(L-1) + O(L-2) + ... + O(1) = 2(O(L-2) + O(L-3) + ... + O(1)) = 2(2(O(L-3) + ... + O(1))) = 2^L
    */
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
        for (String word : words) {
            if (dfs(word, root, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean dfs(String word, TrieNode root, int count , int pos) {
        if (pos == word.length()) {
            return count > 1;
        }
        TrieNode cur = root;
        for (int i = pos; i < word.length(); ++i) {
            if (cur.children[word.charAt(i) - 'a'] != null) {
                if (cur.children[word.charAt(i) - 'a'].isWord && dfs(word, root, count + 1, i + 1)) {
                    return true;
                }
                cur = cur.children[word.charAt(i) - 'a'];
            } else return false;
        }
        return false;
    }
}
// @lc code=end

