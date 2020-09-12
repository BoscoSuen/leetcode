/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
/*
O(n) * O(1/2 + 1/3 + 1/5 + ... + 1/(last prime before n))
= O(n) * O(log(log(n)))
= O(nlog(log(n)))
*/
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n + 1];
        for (int i = 2; i < n; ++i) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j <= n; ++j) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}
// @lc code=end

