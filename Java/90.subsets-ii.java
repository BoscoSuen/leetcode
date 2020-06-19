/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    /*
    为了去重, 需要提前给数组排序
    backtracking时如果当前和前一个相等就跳过
    time: O(n*2^n) T(n) = n* {T(n - 1) + T(n - 2) + ... T(1)}, 每次递归copy list的时间也算上要乘以n
    space: O(n)
    */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, int[] nums, List<Integer> cur, int pos) {
        res.add(new ArrayList<>(cur));
        for (int i = pos; i < nums.length; ++i) {
            // 去重从pos的下一个开始, 而不是从0的下一个(每层递归的第二个位置开始判断去重)
            if (i > pos && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            backTracking(res, nums, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
// @lc code=end

