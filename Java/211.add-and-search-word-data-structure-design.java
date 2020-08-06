/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */

// @lc code=start

/*
Trie
对于'.'的情况，遍历所有children进行dfs
time: O(26^n) n:length of word
space: O(num of words * len of word)
*/
class WordDictionary {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word, root, 0);
    }
    
    private boolean dfs(String word, TrieNode root, int pos) {
        if (pos == word.length()) {
            return root.isWord;
        }
        if (word.charAt(pos) == '.') {
            for (int i = 0; i < 26; ++i) {
                if (root.children[i] != null && dfs(word, root.children[i], pos + 1)) {
                    return true;
                }
            }
        } else {
            char c = word.charAt(pos);
            return root.children[c - 'a'] != null && dfs(word, root.children[c - 'a'], pos + 1);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

