/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
/*
先将products排序，然后建Trie,每个node存对应prefix的product(最多3个)
time: O(nlogn + O(n * len(product) for building trie + O(len(searchWord) for query)
space: O(n * len(product))
* 注意query的写法, leetcode有一个很复杂的corner case
*/
class Solution {
    class TrieNode {
        List<String> list;
        TrieNode[] children;
        public TrieNode() {
            list = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        for (String product : products) {
                cur = root;
            for (char c : product.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
                if (cur.list.size() < 3) cur.list.add(product);
            }
        }
        cur = root;
        for (char c : searchWord.toCharArray()) {
            if (cur != null) cur = cur.children[c - 'a'];
            res.add(cur == null ? new ArrayList<>() : cur.list);
        }
        return res;
    }
}
// @lc code=end

