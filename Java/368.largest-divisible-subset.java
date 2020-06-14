/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */

// @lc code=start
class Solution {
    /*
    如果对于一个满足条件的set, 对于一个新的数，如果它能被set中的最小数整除或者能被整除set最大数,则这个数可以加入到set中
    eg: {4, 8, 16} 2能被4整除, 32能整除16
    考虑到能否新加到set,将数组排序，保证先考虑小的数，再考虑大的数
    思路类似LIS(longest increasing subsequence)问题,维护一个最大数为n的dp数组tail[n],t[n]表示最大数为n的subset的最大长度
    为了得到输出的结果，需要用一个prev数组来记录dp更新的index
    */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int max = 0, maxIdx = -1;
        int[] count = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(count, 1);
        Arrays.fill(prev, -1);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                // 倒序遍历j方便记录prev[i], 因为更大的subset最大的数也会比较大, 倒序更新过一次之后之前的不会再被更新了
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            
            if (count[i] > max) {
                max = count[i];
                maxIdx = i;
            }
        }
        
        for (int i = 0; i < max; ++i) {
            res.add(nums[maxIdx]);
            maxIdx = prev[maxIdx];
        }
        return res;
    }
}
// @lc code=end

