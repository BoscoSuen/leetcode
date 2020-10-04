/*
 * @lc app=leetcode id=572 lang=golang
 *
 * [572] Subtree of Another Tree
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
func isSubtree(s *TreeNode, t *TreeNode) bool {
    if s == nil {
        return false
    }
    if isSame(s, t) {
        return true
    }
    return isSubtree(s.Left, t) || isSubtree(s.Right, t)
}

func isSame(s *TreeNode, t *TreeNode) bool {
    if s == nil && t == nil {
        return true
    }
    if s == nil || t == nil {
        return false
    }
    if s.Val != t.Val {
        return false
    }
    return isSame(s.Left, t.Left) && isSame(s.Right, t.Right)
}
// @lc code=end

