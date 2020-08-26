/*
 * @lc app=leetcode id=1032 lang=java
 *
 * [1032] Stream of Characters
 */

// @lc code=start

/*
将dict中的单词逆序存入一个trie中，query的时候倒序在trie中搜索
time: O(n * m) n: number of words m: length of word
space: O(n * m)
*/
class StreamChecker {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        root = new TrieNode();
        buildTrie(words);
        sb = new StringBuilder();
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode cur = root;
        for (int i = sb.length() - 1; i >= 0 && cur != null; --i) {
            cur = cur.children[sb.charAt(i) - 'a'];
            if (cur != null && cur.isWord) {
                return true;
            }
        }
        return false;
    }
    
    private void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            // build Trie in reverse order
            for (int i = word.length() - 1; i >= 0; --i) {
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    cur.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
// @lc code=end

