/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    利用set存储需要删除的数字  
    root进行递归：如果需要删除，当前节点返回null, 并标记isRoot 和 deleted, 
    如果deleted为true, 则left & right child标记为isRoot = true
    time: O(n)
    space: O(n)
    */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) set.add(i);
        helper(root, set, res, true);
        return res;
    }

    private TreeNode helper(TreeNode root, Set<Integer> set, List<TreeNode> res, boolean isRoot) {
        if (root == null) return null;
        boolean deleted = set.contains(root.val);
        if (isRoot && !deleted) res.add(root);
        root.left = helper(root.left, set, res, deleted);
        root.right = helper(root.right, set, res, deleted);
        return deleted ? null : root;
    }
}
// @lc code=end

