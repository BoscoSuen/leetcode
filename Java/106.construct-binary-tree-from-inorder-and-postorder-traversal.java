/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
*/
class Solution {
    /*
    对于inorder, 左子树和右子树的节点在root的两边
    postorder, root是最后一个元素
    利用hashmap存储inorder元素和index的mapping, 递归
    time: O(n)
    space: O(h)
    */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return helper(map, postorder, 0, inorder.length - 1, postorder.length - 1);
    }
    
    private TreeNode helper(Map<Integer, Integer> map, int[] postorder, int inStart, int inEnd, int postEnd) {
       if (postEnd < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int pos = map.get(postorder[postEnd]);
        root.left = helper(map, postorder, inStart, pos - 1, postEnd - (inEnd - pos + 1));
        root.right = helper(map, postorder, pos + 1, inEnd, postEnd - 1);
        return root;
    }
}
// @lc code=end

