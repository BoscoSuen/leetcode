/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    类似preorder, 但是仅当level = res.size()时，之前level都加上了目标node，此时加上的root就是right view的第一个
    之后每次先向右边递归就能得到每层的right view
    time: O(h)
    space: O(h)
    */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        rightView(root, res, 0);
        return res;
    }
    
    private void rightView(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (level == res.size()) res.add(root.val);
        rightView(root.right, res, level + 1);
        rightView(root.left, res, level + 1);
    }
}
// @lc code=end

