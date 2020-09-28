/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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
    time: O(nlogn)
    space: O(n)
    */
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, 0);
        for (int i = min; i <= max; ++i) {
            List<Integer> cur = new ArrayList<>();
            if (map.containsKey(i)) {
                for (PriorityQueue<Integer> pq : map.get(i).values()) {
                    while (!pq.isEmpty()) {
                        cur.add(pq.poll());
                    }
                }
            }
            res.add(cur);
        }
        return res;
    }
    
    private void dfs(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        min = Math.min(min, x);
        max = Math.max(max, x);
        map.putIfAbsent(x, new TreeMap<>());
        map.get(x).putIfAbsent(y, new PriorityQueue<>());
        map.get(x).get(y).offer(root.val);
        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }
}
// @lc code=end

