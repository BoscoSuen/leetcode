/*
 * @lc app=leetcode id=947 lang=golang
 *
 * [947] Most Stones Removed with Same Row or Column
 */

// @lc code=start
func removeStones(stones [][]int) int {
    u := newUnion(20000)
    for _, s := range stones {
        u.union(s[0], s[1] + 10000)     // 避免坐标轴的重叠，y坐标加10000
    }

    keeps := make(map[int]int, 1000)
    for _, s := range stones {
        root := u.find(s[0])
        keeps[root]++
    }
    return len(stones) - len(keeps)
}

type union struct {
    parent []int
}

func newUnion(size int) *union {
    parent := make([]int, size)
    for i := range parent {
        parent[i] = i
    }
    return &union {
        parent : parent,
    }
}

func (u *union) union(x, y int) {
    xp, yp := u.find(x), u.find(y)
    u.parent[yp] = xp
}

func (u *union) find(x int) int {
    for u.parent[x] != x {
        u.parent[x] = u.parent[u.parent[x]]
        x = u.parent[x]
    }
    return x
}
// @lc code=end

