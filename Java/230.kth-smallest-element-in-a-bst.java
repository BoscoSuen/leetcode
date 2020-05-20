/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
    time: O(n)
    space: O(height) or O(k)
    */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list, k);
        return list.get(k - 1);
    }
    
    private void traversal(TreeNode root, List<Integer> list, int k) {
        if (root == null || list.size() >= k) return;
        traversal(root.left, list, k);
        list.add(root.val);
        traversal(root.right, list, k);
    }
}
// @lc code=end

