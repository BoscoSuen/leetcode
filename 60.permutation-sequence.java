/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    对于n个数字，如果确定第一个数字之后，剩下的数字总共有(n - 1)!个排列，用k-1去除以它就可以得到其首数字，
    然后我们更新k为其余数，删除掉输出结果首数字对应的数字，然后重复上述过程。
    注意：在存有1-n的list中，确定一个数字一定要将其从List中删除，否则会出现结果的重复。例如除以
    (n -1)!时如果为0的话就会一直返回1而不会得到list中剩余的数字
    time: O(n^2)
    space: O(n)
    */
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = i * factorial[i - 1];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            list.add(i);
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; --i) {
            int idx = k / factorial[i];  // 第一个数字之外有(n-1)!个排列
            sb.append(list.get(idx));
            list.remove(idx);   // time complexity: O(n)
            k %= factorial[i];
        }
        return sb.toString();
    }
}
// @lc code=end

