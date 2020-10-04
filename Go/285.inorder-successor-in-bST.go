/*
 * @lc app=leetcode id=285 lang=golang
 *
 * [285] Inorder Successor in BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderSuccessor(root *TreeNode, p *TreeNode) *TreeNode {
    if root == nil {
        return nil
    }
    if (root.Val <= p.Val) {
        return inorderSuccessor(root.Right, p)
    }
    res := inorderSuccessor(root.Left, p)
    if res == nil {
        return root
    } else {
        return res
    }
}
// @lc code=end

