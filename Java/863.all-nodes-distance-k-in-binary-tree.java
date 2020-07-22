/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
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
    建图+bfs,注意bfs要加上visited
    time: O(n)
    space: O(n)
    */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, graph, null);
        if (!graph.containsKey(target)) return res;
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size; ++i) {
                    res.add(q.poll().val);
                }
                return res;
            }
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();
                List<TreeNode> edges = graph.get(cur);
                for (TreeNode next : edges) {
                    if (visited.add(next)) {
                        q.offer(next);
                    }
                }
            }
            --K;
        }
        return res;
    }
    
    private void buildGraph(TreeNode root, Map<TreeNode, List<TreeNode>> graph, TreeNode parent) {
        if (root == null) return;
        if (!graph.containsKey(root)) {
            graph.put(root, new ArrayList<>());
            if (parent != null) {
                graph.get(parent).add(root);
                graph.get(root).add(parent);
            }
            buildGraph(root.left, graph, root);
            buildGraph(root.right, graph, root);
        }
    }
}
// @lc code=end

