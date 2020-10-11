/*
 * @lc app=leetcode id=839 lang=java
 *
 * [839] Similar String Groups
 */

// @lc code=start
class Solution {
    /*
    time: O(N^2 (max(W, log N)))
    space: O(n)
    */
    class UF {
        int[] parent;
        int size;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
            size = n;
        }

        private void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[py] = px;
                size--;
            }
        }

        private int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
    public int numSimilarGroups(String[] A) {
        if (A == null || A.length == 0) return 0;
        UF uf = new UF(A.length);
        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                if (isSimilar(A[i], A[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.size;
    }

    private boolean isSimilar(String a, String b) {
        if (a.length() != b.length()) return false;
        int count = 0;
        for (int i= 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i) && ++count > 2) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

