/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    将之前的计算结果储存在prev中递归求解
    time: O(h)
    space: O(h)
    */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return getSum(root, 0);
    }
    
    private int getSum(TreeNode root, int prev) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return prev * 10 + root.val;
        return getSum(root.left, prev * 10 + root.val) + getSum(root.right, prev * 10 + root.val);
    }
}
// @lc code=end

