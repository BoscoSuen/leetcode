/*
 * @lc app=leetcode id=489 lang=java
 *
 * [489] Concatenated Words
 */

// @lc code=start
class Solution {
    /*
    dfs: 记录相对坐标, dfs时还要记录当前朝向(在dirs中的位置), 加上i就是新的朝向
    backtracking的时候要注意：除了要转180度后退之后，还要转180度回到原来的朝向
    time: O(size of room)
    space: O(size of room)
    */
    int[] dirs = new int[]{1, 0, -1, 0, 1};
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        visited.add("0 - 0");
        dfs(robot, visited, 0, 0, 0);
    }
    
    private void dfs(Robot robot, Set<String> visited, int r, int c, int cur) {
        robot.clean();
        for (int i = 0; i < 4; ++i) {
            int dir = (i + cur) % 4;
            int nextR = r + dirs[dir];
            int nextC = c + dirs[dir + 1];
            if (visited.add(nextR + " - " + nextC) && robot.move()) {
                dfs(robot, visited, nextR, nextC, dir);
                // backtrack
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
}
// @lc code=end

