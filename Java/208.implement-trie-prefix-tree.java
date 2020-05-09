/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
/*
每一个字符对应一个node,是末尾标记成isWord,否则标记成false.
node的children是prefix的下一个的所有可能
eg: [ab, adc, ade]
             a|0
        b|1      d|0
              c|1    e|1
time: O(l)
space: O(prefix, l * num of words)
*/
class Trie {
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
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        // time: O(length of word)
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int pos = (int)(word.charAt(i) - 'a');
            if (cur.children[pos] == null) {
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.isWord = true;  // end of the word
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode res = find(word);
        return res != null && res.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String str) {
        // time: O(length of word)
        TrieNode cur = root;
        for (int i = 0; i < str.length(); ++i) {
            int pos = (int)(str.charAt(i) - 'a');
            if (cur.children[pos] == null) return null;
            cur = cur.children[pos];
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

