/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    /*
    freq有上限，better than O(logn)可以使用bucket sort
    time: O(n)
    space: O(n)
    */
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List[] bucket = new List[n + 1];
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(key);
        }
        int[] res = new int[k];
        int pos = 0;
        for (int i = n; pos < k && i > 0; --i) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && pos < k; ++j) {
                    res[pos++] = (int)bucket[i].get(j);
                }
            }
        }
        return res;
    }
}
// @lc code=end

