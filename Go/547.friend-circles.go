/*
 * @lc app=leetcode id=547 lang=golang
 *
 * [547] Friend Circles
 */

// @lc code=start
func findCircleNum(M [][]int) int {
    visited := map[int]bool{}
    count := 0

    for i := 0; i < len(M); i++ {
        if !visited[i] {
            count++
            dfs(M, visited, i)
        }
    }
    return count
}

func dfs(M [][]int, visited map[int]bool, pos int) {
    if visited[pos] {
        return
    }
    visited[pos] = true
    for next, val := range M[pos] {
        if val == 1 && !visited[next] {
            dfs(M, visited, next)
        }
    }
}

// @lc code=end

