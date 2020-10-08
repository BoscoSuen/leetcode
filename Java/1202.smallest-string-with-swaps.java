/*
 * @lc app=leetcode id=1202 lang=java
 *
 * [1202] Smallest String With Swaps
 */

// @lc code=start
class Solution {
    /*
    union-find+priorityqueue
    time: O(nlogn)
    space: O(n)
    */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(parent, pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int root = find(parent, i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            int root = find(parent, i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }

    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            parent[py] = px;
        }
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
// @lc code=end

