/*
 * @lc app=leetcode id=421 lang=java
 *
 * [421] Maximum XOR of Two Numbers in an Array
 */

// @lc code=start
/*
对于尽可能大的xor, 高位bit xor的结果尽量是1
将所有的数按照bit从高到低储存在bit中(如果是比较小的数之前要补0保证高度相等)
遍历trie，如果xor位children有trienode, 向另一个方向遍历找到最大的xor pair
time: O(n)
space: O(n)
*/
class Solution {
    class TrieNode {
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; --i) {
                int curBit = (num >>> i) & 1;
                if (cur.children[curBit] == null) {
                    cur.children[curBit] = new TrieNode();
                }
                cur = cur.children[curBit];
            }
        }
        int res = 0;
        for (int num : nums) {
            TrieNode cur = root;
            int sum = 0;
            for (int i = 31; i >= 0; --i) {
                int curBit = (num >>> i) & 1;
                if (cur.children[curBit ^ 1] != null) {
                    cur = cur.children[curBit ^ 1];
                    sum += (1 << i);
                } else {
                    cur = cur.children[curBit];
                }
            }
            res = Math.max(sum, res);
        }
        return res;
    }
}
// @lc code=end

