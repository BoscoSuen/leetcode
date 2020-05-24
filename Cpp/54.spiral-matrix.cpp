/*
 * @lc app=leetcode id=54 lang=cpp
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> res;
        if (matrix.empty()) return res;
        int rowMin = 0, rowMax = matrix.size() - 1, colMin = 0, colMax = matrix[0].size() - 1;
        while (rowMin <= rowMax && colMin <= colMax) {
            for (int i = colMin; i <= colMax; ++i) {
                res.push_back(matrix[rowMin][i]);
            }
            rowMin++;
            for (int i = rowMin; i <= rowMax; ++i) {
                res.push_back(matrix[i][colMax]);
            }
            colMax--;
            if (rowMin <= rowMax) {
                for (int i = colMax; i >= colMin; --i) {
                    res.push_back(matrix[rowMax][i]);
                }
                rowMax--;
            }
            if (colMin <= colMax) {
                for(int i = rowMax; i >= rowMin; --i) {
                    res.push_back(matrix[i][colMin]);
                }
                colMin++;
            }
        }
        return res;
    }
};
// @lc code=end

