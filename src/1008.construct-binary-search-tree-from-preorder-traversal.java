/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    递归时传当前BST的upper bound
    time: O(n)
    space:O(n)
    */
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return helper(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = helper(preorder, root.val);
        root.right = helper(preorder, bound);
        return root;
    }
}
// @lc code=end

