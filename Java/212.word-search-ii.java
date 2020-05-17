/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    /*
    常规dfs会超时，利用trie来进行剪枝
    将words建trie
    dfs过程中，如果当前的trieNode==null就直接返回，碰到末尾节点返回当前string
    time: O(mn * min(length of word, mn))
    space: trie: O(num of words * len of word) search : O(mn)
    */
    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    cur.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.word = word;
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(res, board, i, j, root);
            }
        }
        return res;
    }

    private void dfs(List<String> res, char[][] board, int i, int j, TrieNode root) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || root.children[board[i][j] - 'a'] == null) {
            return;
        }
        if (root.children[board[i][j] - 'a'].word != null) {
            res.add(root.children[board[i][j] - 'a'].word);
            root.children[board[i][j] - 'a'].word = null;   // visited, de-duplicate
        }
        char c = board[i][j];
        root = root.children[board[i][j] - 'a'];
        board[i][j] = '#';  // visited
        dfs(res, board, i + 1, j, root);
        dfs(res, board, i - 1, j, root);
        dfs(res, board, i, j + 1, root);
        dfs(res, board, i, j - 1, root);
        board[i][j] = c;
    }
}
// @lc code=end

