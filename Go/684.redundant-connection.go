/*
 * @lc app=leetcode id=684 lang=golang
 *
 * [684] Redundant Connection
 */

// @lc code=start
func findRedundantConnection(edges [][]int) []int {
    n := len(edges)
    parent := make([]int, n + 1)
    // init UF
    for i := 0; i < n; i++ {
        parent[i] = i
    }
    for _, edge := range edges {
        p1 := find(parent, edge[0])
        p2 := find(parent, edge[1])
        if p1 == p2 {
            return edge
        }
        // union
        parent[p2] = p1
    }
    return nil
}

func find(parent []int, x int) int {
    for parent[x] != x {
        parent[x] = parent[parent[x]]
        x = parent[x]
    }
    return x
}
// @lc code=end

