/*
 * @lc app=leetcode id=1145 lang=java
 *
 * [1145] Binary Tree Coloring Game
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
    如果一个节点确定之后，其subtree对方都不能访问
    将left, right, parent看作三个subtree
    比较是否有一边subtree的数量大于n/2
    if countLeft or countRight are bigger than n/2, player 2 chooses this child of the node and will win.
    If countLeft + countRight + 1 is smaller than n/2, player 2 chooses the parent of the node and will win;
    otherwise, lose
    */
    int l, r;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root, x);
        return Math.max(l, Math.max(r, n - l - r - 1)) > n / 2;
    }
    
    private int count(TreeNode root, int target) {
        if (root == null) return 0;
        int left = count(root.left, target);
        int right = count(root.right, target);
        if (root.val == target) {
            l = left;
            r = right;
        }
        return left + right + 1;
    }
}
// @lc code=end

