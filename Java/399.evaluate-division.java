/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start
class Solution {
    /*
    建图+bfs, 注意分子分母倒过来也可以，所以是无向图，遍历时要加visited
    time: O(V+E) per query
    space: O(V+E)
    */
    Map<String, Map<String, Double>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            if (!graph.containsKey(queries.get(i).get(0)) || !graph.containsKey(queries.get(i).get(1))) {
                // ["x", "x"]的情况会直接返回base case
                res[i] = -1.0;
            } else {
                res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
            }
        }
        return res;
    }
    
    private void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); ++i) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            graph.putIfAbsent(first, new HashMap<>());
            graph.putIfAbsent(second, new HashMap<>());
            graph.get(first).put(second, values[i]);
            graph.get(second).put(first, 1.0 / values[i]);  // reverse division
        }
    }
    
    private double dfs(String a, String b, Set<String> visited) {
        if (a.equals(b)) return 1.0;
        double res = -1;
        visited.add(a);
        if (graph.containsKey(a)) {
            Map<String, Double> map = graph.get(a);
            for (String next : map.keySet()) {
                if (!visited.contains(next)) {
                    res = dfs(next, b, visited);
                    if (res > 0) return map.get(next) * res;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

