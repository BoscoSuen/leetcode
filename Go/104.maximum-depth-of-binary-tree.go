/*
 * @lc app=leetcode id=104 lang=golang
 *
 * [104] Maximum Depth of Binary Tree
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
func maxDepth(root *TreeNode) int {
    return helper(root, 0);
}

func helper(root *TreeNode, depth int) int {
    if root == nil {
        return depth
    }
    return max(helper(root.Left, depth + 1), helper(root.Right, depth + 1))
}

func max(x, y int) int {
    if x >= y {
        return x
    } else {
        return y
    }
}
// @lc code=end

