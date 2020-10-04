/*
 * @lc app=leetcode id=98 lang=golang
 *
 * [98] Validate Binary Search Tree
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
func isValidBST(root *TreeNode) bool {
    return helper(root, nil, nil)
}

func helper(root, min, max *TreeNode) bool {
    if root == nil {
        return true
    }
    if min != nil && root.Val <= min.Val {
        return false
    }
    if max != nil && root.Val >= max.Val {
        return false
    }
    return helper(root.Left, min, root) && helper(root.Right, root, max)
}
// @lc code=end

