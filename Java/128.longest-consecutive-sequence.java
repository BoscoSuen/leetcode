/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    /*
    使用一个集合HashSet存入所有的数字，然后遍历数组中的每个数字，如果其在集合中存在，那么将其移除，
    然后分别用两个变量pre和next算出其前一个数跟后一个数，然后在集合中循环查找，如果pre在集合中，
    那么将pre移除集合，然后pre再自减1，直至pre不在集合之中，对next采用同样的方法，
    * 移除元素是为了避免大量的重复计算，eg，我们在遍历到4的时候，会向下遍历3，2，1，如果都不移除数字的话，遍历到1的时候，还会遍历2，3，4。
    那么next-pre-1就是当前数字的最长连续序列，更新res即可
    time: O(n)
    space: O(n)
    */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                int prev = num - 1, next = num + 1;
                while (set.remove(prev)) prev--;
                while (set.remove(next)) next++;
                res = Math.max(res, next - prev - 1);
            }
        }
        return res;
    }
}
// @lc code=end

