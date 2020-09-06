/*
 * @lc app=leetcode id=1305 lang=java
 *
 * [1305] All Elements in Two Binary Search Trees
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
*/
class Solution {
    /*
    Two stack and merge sort
    time: O(n)
    space: O(h)
    */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        pushLeft(s1, root1);
        pushLeft(s2, root2);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            Stack<TreeNode> cur;
            if (s1.isEmpty()) cur = s2;
            else if (s2.isEmpty()) cur = s1;
            else {
                cur = s1.peek().val < s2.peek().val ? s1 : s2;
            }
            TreeNode node = cur.pop();
            res.add(node.val);
            pushLeft(cur, node.right);
        }
        return res;
    }
    
    private void pushLeft(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
// @lc code=end

