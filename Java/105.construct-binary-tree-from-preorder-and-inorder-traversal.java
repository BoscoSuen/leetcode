/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    the root is the start idx of the preorder, find the index in inorder
    get the left length = inorder root idx - preorder start idx
    root.right idx = preorder start idx + 1 + left length
    left length = inorder root idx - inorder start
    do divide and conquer
    time: O(n)
    space: O(height)
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return helper(map, preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(Map<Integer, Integer> map, int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = helper(map, preorder, inorder, preStart + 1, inStart, map.get(preorder[preStart]) - 1);
        root.right = helper(map, preorder, inorder, preStart + map.get(preorder[preStart]) - inStart + 1, map.get(preorder[preStart]) + 1, inEnd);
        return root;
    }
}
// @lc code=end

