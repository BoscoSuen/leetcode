/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 */

// @lc code=start
class Solution {
    /*
    Greedy
    记录每个数字出现的次数，再加一个need map记录在某些列中是某需要下一个数字
    eg:[1 2 3]列已经出现的情况下，4的need就要+1
    遍历数组，如果当前need存在，则need value - 1，下一个need value+1
    如果不存在，但是num + 1, num + 2在freq map中都存在，证明可以新开一个序列
    如果以上都不满足，则返回false
    注意每次需要把当前的freq - 1
    time: O(n)
    space: O(n)
    */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> need = new HashMap<>();
        for (int num : nums) {
            if (freq.get(num) == 0) continue;
            if (need.containsKey(num) && need.get(num) > 0) {
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            } else if (freq.containsKey(num + 1) && freq.containsKey(num + 2) && freq.get(num + 1) > 0 && freq.get(num + 2) > 0) {
                // new subsequence
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
            } else return false;
            freq.put(num, freq.get(num) - 1);
        }
        return true;
    }
}
// @lc code=end

