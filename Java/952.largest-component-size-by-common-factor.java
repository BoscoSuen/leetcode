/*
 * @lc app=leetcode id=952 lang=java
 *
 * [952] Largest Component Size by Common Factor
 */

// @lc code=start
class Solution {
    /*
    对于存在公因数，可以将这些数和公因数利用union find连接起来
    最后遍历这些数，找到相同parent出现最多的次数
    time: O(n * sqrt(max(A)))
    space: O(max(A))
    */
    class UF {
        int[] parent;
        int[] rank;
        public UF(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }
        
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
        
        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
    public int largestComponentSize(int[] A) {
        if (A == null || A.length == 0) return 0;
        int max = findMax(A);
        UF uf = new UF(max + 1);
        int res = 0;
        for (int a : A) {
            for (int i = 2; i * i <= a; ++i) {
                if (a % i == 0) {
                    uf.union(a, i);
                    uf.union(a, a / i);
                }
            }
        }
        // 找到所有A中元素中parent出现次数最多的
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : A) {
            int parent = uf.find(a);
            count.put(parent, count.getOrDefault(parent, 0) + 1);
            res = Math.max(res, count.get(parent));
        }
        return res;
    }
    
    private int findMax(int[] A) {
        int res = Integer.MIN_VALUE;
        for (int a : A) {
            res = Math.max(res, a);
        }
        return res;
    }
}
// @lc code=end

