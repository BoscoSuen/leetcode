/*
 * @lc app=leetcode id=957 lang=java
 *
 * [957] Prison Cells After N Days
 */

// @lc code=start
class Solution {
    /*
    利用Arrays.toString(int[])将每个状态存入一个set里判断是否有cycle
    time: O(n) or O(len of cycle)
    space: O(n)
    */
    public int[] prisonAfterNDays(int[] cells, int N) {
        boolean hasCycle = false;
        Set<String> set = new HashSet<>();
        int cycle = 0;
        for (int i = 0; i < N; ++i) {
            String next = Arrays.toString(getNext(cells));
            if (!set.contains(next)) {
                set.add(next);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = getNext(cells);
        }
        if (hasCycle) {
            N %= cycle;
            for (int i = 0; i < N; ++i) {
                cells = getNext(cells);
            }
        }
        return cells;
    }
    
    public int[] getNext(int[] cells) {
        int[] res = new int[cells.length];
        for (int i = 1; i < cells.length - 1; ++i) {
            res[i] = cells[i -1] == cells[i + 1] ? 1 : 0;
        }
        return res;
    }
}
// @lc code=end

