/*
 * @lc app=leetcode id=835 lang=java
 *
 * [835] Image Overlap
 */

// @lc code=start
class Solution {
    /*
    记录所有1的位置，然后将所有的1的相对偏移量存进一个map里，最后得到相对偏移量最多的1的个数
    time: O(n^4)
    space: O(n^2)
    */
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        List<int[]> la = new ArrayList<>();
        List<int[]> lb = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] == 1) {
                    la.add(new int[]{i, j});
                }
                if (B[i][j] == 1) {
                    lb.add(new int[]{i, j});
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int[] a: la) {
            for (int[] b : lb) {
                String dis = (a[0] - b[0]) + "-" + (a[1] - b[1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
        }
        int res = 0;
        for (String s : map.keySet()) {
            res = Math.max(res, map.get(s));
        }
        return res;
    }
}
// @lc code=end

