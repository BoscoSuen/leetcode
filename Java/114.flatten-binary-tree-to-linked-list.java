/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    flat左右两子树，然后将右子树接到左子树的最末端
    time: O(n)
    space: O(n)
    */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left == null) return;
        TreeNode cur = root.left;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
// @lc code=end

