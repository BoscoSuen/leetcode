/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
由 root 根结点往下，分别找最靠左边和最靠右边的路径长度，如果长度相等，则证明二叉树最后一层节点是满的，是满二叉树，直接返回节点个数，如果不相等，则节点个数为左子树的节点个数加上右子树的节点个数再加1(根节点)，其中左右子树节点个数的计算可以使用递归来计算
time: O((logn)^2)
space: O((logn)^2)
    */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int hLeft = leftHeight(root);
        int hRight = rightHeight(root);
        if (hLeft == hRight) return (int)Math.pow(2.0, (double)hLeft) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    int leftHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + leftHeight(root.left);
    }
    
    int rightHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + rightHeight(root.right);
    }
}
// @lc code=end

