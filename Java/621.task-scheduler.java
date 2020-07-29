/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    /*
    greedy
    找到频率最高的字母，和其相同频率的字母会放到最后，其余的会放到中间的slot里面
    eg: A A B 1
    -> AB A
    A A A B B B 2
    AB_AB_AB
    len = mqx freq * (n + 1) + maxfreq的字母种类数
    */
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int i = 25;
        while (i >= 0 && freq[i] == maxFreq) i--;
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + 25 - i);
    }
}
// @lc code=end

