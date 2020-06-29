/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    /*
    Hierholzer’s Algorithm:从一个点出发，每条边都只走一遍，结束于另一个点。
    欧拉路径条件:
1.在无向图中，所有顶点的度数均为偶，则存在 Eularian cycle；若有且仅有两个顶点的度数为奇，其余的都为偶，则存在     Eularian path；
2.在有向图中，所有顶点的入度数等于出度数，则存在 Eularian cycle；若有且仅有两个顶点：其中2一个入度数比出度数大 1，另一个入度数比出度数小 1，其余的顶点入度数等于出度数，则存在 Eularian path.

    规定从JFK开始，按照lexical order找到路径
    可以利用dfs, 其graph的edge可以用一个priorityqueue来储存
    对于边的遍历，由于一定有解，先dfs找到最后一个节点，然后回溯的时候加到之前结果的最前面(反向输出遍历结果)
    先将当前结果加到list中有可能会遍历到错误的路径:[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]],
    错误遍历会是:["JFK","KUL"]
    time: O(Elog(E/V))   worst case: 所有的边都集中在一个点上，pq排序的时间为logE
    space: O(V+E)
    */
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> list : tickets) {
            map.putIfAbsent(list.get(0), new PriorityQueue<>());
            map.get(list.get(0)).offer(list.get(1));
        }
        dfs(res, map, "JFK");
        return res;
    }
    
    private void dfs(List<String> res, Map<String, PriorityQueue<String>> map, String cur) {
        if (map.containsKey(cur) && !map.get(cur).isEmpty()) {
            PriorityQueue<String> edges = map.get(cur);
            while (!edges.isEmpty()) {
                String next = edges.poll();    // visited
                dfs(res, map, next);
            }
        }
        res.add(0, cur);
    }
}
// @lc code=end

