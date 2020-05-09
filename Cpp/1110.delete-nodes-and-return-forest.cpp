/*
 * @lc app=leetcode id=1110 lang=cpp
 *
 * [1110] Delete Nodes And Return Forest
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
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        vector<TreeNode*> res;
        unordered_set<int> set(to_delete.begin(), to_delete.end());
        bool isRoot = (set.find(root->val) == set.end());
        helper(res, root, set, isRoot);
        return res;
    }
private:
    TreeNode* helper(vector<TreeNode*>& res, TreeNode* root, unordered_set<int>& set, bool& isRoot) {
        if (root == NULL) return NULL;
        bool deleted = set.find(root->val) != set.end();
        if(isRoot && !deleted) res.push_back(root);
        root->left = helper(res, root->left, set, deleted);
        root->right = helper(res, root->right, set, deleted);
        return deleted ? NULL : root;
    }
};
// @lc code=end

