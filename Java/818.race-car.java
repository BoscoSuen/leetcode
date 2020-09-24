/*
 * @lc app=leetcode id=818 lang=java
 *
 * [818] Race Car
 */

// @lc code=start
class Solution {
    /*
    将A和R看作每一步的两个状态，用BFS来找最短路径
    time: O(2^n)
    space: O(2^n)
    */
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 1});
        Set<String> visited = new HashSet<>();
        visited.add("0_1");
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int pos = cur[0];
                int speed = cur[1];
                if (pos == target) return step;
                // A
                int pos1 = pos + speed;
                int speed1 = speed * 2;
                q.offer(new int[]{pos1, speed1});   // 加进visited数组会超时
                // R
                int speed2 = speed > 0 ? -1 : 1;
                if (visited.add(pos + "_" + speed2)) {
                    q.offer(new int[]{pos, speed2});
                }
            }
            step++;
        }
        return -1;
    }
}
// @lc code=end

