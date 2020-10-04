/*
 * @lc app=leetcode id=314 lang=golang
 *
 * [314] Binary Tree Vertical Order Traversal
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
func verticalOrder(root *TreeNode) [][]int {
    if root == nil {
        return [][]int{}
    }
    m := make(map[int][]int)

    q1 := []*TreeNode{root}
    q2 := []int{0}

    min := math.MaxInt32
    max := math.MinInt32

    for len(q1) > 0 {
        cur := q1[0]
        q1 = q1[1:]     // poll
        col := q2[0]
        q2 = q2[1:]

        list := m[col]
        if list == nil {
            list = []int{cur.Val}
        } else {
            list = append(list, cur.Val)
        }
        m[col] = list
        if col < min {
            min = col
        }
        if col > max {
            max = col
        }
        if cur.Left != nil {
            q1 = append(q1, cur.Left)
            q2 = append(q2, col - 1)
        }
        if cur.Right != nil {
            q1 = append(q1, cur.Right)
            q2 = append(q2, col + 1)
        }
    }
    res := make([][]int, 0, max - min + 1)
    for i := min; i <= max; i++ {
        res = append(res, m[i])
    }
    return res
}
// @lc code=end

