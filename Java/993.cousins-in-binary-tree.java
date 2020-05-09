/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
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
    dfs, 将xParent,yParent,xDepth,yDepth设为global
    time: O(n)
    space: O(height)
    */
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1;
    int yDepth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        dfs(root, x, y, 0, null);
        return xParent != null && yParent != null && xDepth == yDepth && xParent.val != yParent.val;
    }

    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null || (xParent != null && yParent != null)) return;
        if (root.val == x) {
            xParent = parent;
            xDepth = depth;
        }
        if (root.val == y) {
            yParent = parent;
            yDepth = depth;
        }
        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}
// @lc code=end

