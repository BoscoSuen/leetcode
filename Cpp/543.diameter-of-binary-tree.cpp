/*
 * @lc app=leetcode id=543 lang=cpp
 *
 * [543] Diameter of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int diameterOfBinaryTree(TreeNode* root) {
        if (root == NULL) return 0;
        int res = 0;
        helper(root, res);
        return res;
    }

    int helper(TreeNode* root, int& res) {
        if (root == NULL) return 0;
        int left = helper(root->left, res);
        int right = helper(root->right, res);
        res = max(res, left + right);
        return max(left, right) + 1;
    }
};
// @lc code=end

