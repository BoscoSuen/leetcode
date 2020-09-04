/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
    分左右区间进行recursion
    time: As we have to generate all the possible trees and the total number of possible 
    trees possible is a catalan number which is (4^n)/((n^(3/2))*sqrt(pi)), 
    which makes the time of this algorithm to be O(4^n).
    */
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int low, int high) {
        List<TreeNode> res = new ArrayList<>();
        if (low > high) return res;
        for (int i = low; i <= high; ++i) {
            List<TreeNode> left = helper(low, i - 1);
            List<TreeNode> right = helper(i + 1, high);
            if (left.size() == 0 && right.size() == 0) {
                res.add(new TreeNode(i));
            } else if (left.size() == 0) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.right = r;
                    res.add(root);
                }
            } else if (right.size() == 0) {
                for (TreeNode l : left) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    res.add(root);
                }
            } else {
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

