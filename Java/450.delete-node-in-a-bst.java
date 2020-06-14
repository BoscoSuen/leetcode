/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    eg:         8               key = 3    
              /   \
             3    9
            / \    \  
           2  6    10
             / \
            4  7
             \
              5

    ==>         8
              /   \
             4    9
            / \    \  
           2  6    10
             / \
            5  7
             \
              3(removed)
    对于key node左右子节点都有的情况，找到右子树的最小值和当前root交换, 然后递归右子树
    time: O(height)
    space: O(height)
    */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) root.right =  deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                root.val = findMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
// @lc code=end

