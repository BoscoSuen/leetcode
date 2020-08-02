/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 */

// @lc code=start
class Solution {
    /*
    BFS
    time: O(m * n * (m * n)!)
    解空间为(m*n)!, string处理为O(mn)
    space: O(m * n * (m * n)!)
    */
    public int slidingPuzzle(int[][] board) {
        int count = 0;
        String init = "";
        for (int[] line : board) {
            for (int i : line) {
                init += i;
            }
        }
        String target = "123450";
        Set<String> visited = new HashSet<>();
        visited.add(init);
        Queue<String> q = new LinkedList<>();
        q.offer(init);
        int[] dirs = new int[]{1, 0, -1, 0, 1};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return count;
                }
                int pos = cur.indexOf('0');
                int r = pos / 3;
                int c = pos % 3;
                for (int j = 0; j < 4; ++j) {
                    int nextR = r + dirs[j];
                    int nextC = c + dirs[j + 1];
                    if (nextR >= 0 && nextR < 2 && nextC >= 0 && nextC < 3) {
                        int next = 3 * nextR + nextC;
                        char[] chs = cur.toCharArray();
                        char temp = chs[pos];
                        chs[pos] = chs[next];
                        chs[next] = temp;
                        String nextStr = new String(chs);
                        if (visited.add(nextStr)) {
                            q.offer(nextStr);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
// @lc code=end

