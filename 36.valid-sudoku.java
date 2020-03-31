/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    注意每一列的j对应的是每个3x3方格内的变化，对应坐标是
    [startRow + j /3][startCol + j % 3]
    time: O(1)
    space: O(1)
    */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cubes = new HashSet<>();
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;
                int cubeRow = 3 * (i / 3); // the start row of the cube
                int cubeCol = 3 * (i % 3);
                if (board[cubeRow + j / 3][cubeCol + j % 3] != '.' && !cubes.add(board[cubeRow + j / 3][cubeCol + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

