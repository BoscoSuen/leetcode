/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
/*
eg:[1,3,2], sum = 6, 可以类比 1 222 33 然后随机取
利用一个weight sum数组 [1,4,6]
用Random获取0-5之间的随机数, 0 -> index0   1,2,3->index1   4,5->index2
在sum数组中找到第一个大于random pick的数字
time: O(n)
space: O(1)
*/
class Solution {
    Random rand;
    int[] sum;
    public Solution(int[] w) {
        rand = new Random();
        for (int i = 1; i < w.length; ++i) {
            w[i] += w[i - 1];
        }
        sum = w;
    }
    
    public int pickIndex() {
        int idx = rand.nextInt(sum[sum.length - 1]);
        int pick = Arrays.binarySearch(sum, idx);
        // [1,4,6] ,idx = 1, pick = 0 -> return 1; idx = 3, pick = -2, return 1
        return pick >= 0 ? pick + 1 : -pick - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

