/*
 * @lc app=leetcode id=419 lang=java
 *
 * [419] Battleships in a Board
 */

// @lc code=start
class Solution {
    /*
    只需要从(0,0)开始遍历，只记录左上角的X, 如果遇到其他X,如果上面或左边也是X,说明已经记录过了，直接跳过
    time: O(mn)
    space: O(mn)
    */
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.' || (i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X')) continue;
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

