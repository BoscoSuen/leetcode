/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start
class Solution {
    /*
    time: O(nlogn)  --> union by rank: O(n)
    space: O(n)
    */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.isEmpty()) return res;
        int n = accounts.size();
        int[] parents = new int[n];
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < accounts.get(i).size(); ++j) {
                String email = accounts.get(i).get(j);
                if (map.containsKey(email)) {
                    // same email, different owner, union
                    int p1 = find(parents, i);
                    int p2 = find(parents, map.get(email));
                    if (p1 != p2) {
                        parents[p1] = p2;
                    }
                } else {
                    map.put(email, i);
                }
            }
        }
        // same indexes in parents have been unioned
        Map<Integer, TreeSet<String>> userMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int parent = find(parents, i);
            userMap.putIfAbsent(parent, new TreeSet<>());
            List<String> account = accounts.get(i);
            userMap.get(parent).addAll(account.subList(1, account.size()));
        }
        for (int idx : userMap.keySet()) {
            String name = accounts.get(idx).get(0);
            List<String> account = new ArrayList<>(userMap.get(idx));
            account.add(0, name);
            res.add(account);
        }
        return res;
    }

    private int find(int[] parents, int x) {
        while (x != parents[x]) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }
}
// @lc code=end

