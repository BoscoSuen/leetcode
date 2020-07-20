/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
class Solution {
    /*
           1(0)
         /   \
        3(0)   2(1)
       / \        \  
     5(0) 3(1) (2) 9(3) 
    对于某一个depth, 该行最多2 * depth - 1个node
    如果某一个node的index是i，其left&right child的index是2 * i, 2 * i + 1
    BFS
    利用一个map存储对应node和index和关系，如果下一层有节点，就存进对应的index,并记录每层的length, 找到最大值
    time: O(n)
    space: O(n)
    */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int start = 0, end = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();
                int pos = map.get(cur);
                if (i == 0) start = pos;
                if (i == size - 1) end = pos;
                if (cur.left != null) {
                    map.put(cur.left, 2 * pos);
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    map.put(cur.right, 2 * pos + 1);
                    q.offer(cur.right);
                }
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
// @lc code=end

