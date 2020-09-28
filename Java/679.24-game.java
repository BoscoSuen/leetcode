/*
 * @lc app=leetcode id=679 lang=java
 *
 * [679] 24 Game
 */

// @lc code=start
class Solution {
    /*
    dfs, 将list中的数两个结合之后，list的元素数量-1，最后比较只有一个数的时候和24比较
    time: O(1) 4(cards)x3(to be combined)x4(operations)x3x2x4x2x1x4 = O(9216) = O(1)
    space: O(1)
    */
    public boolean judgePoint24(int[] nums) {
        if (nums == null || nums.length != 4) return false;
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double)num);
        }
        return dfs(list);
    }
    
    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 0.001;  // accuracy: 0.001
        }
        for (int i = 0; i < list.size(); ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                for (double combined : combineElements(list.get(i), list.get(j))) {
                    List<Double> next = new ArrayList<>();
                    next.add(combined);
                    for (int k = 0; k < list.size(); ++k) {
                        if (k == i || k == j) continue;
                        next.add(list.get(k));
                    }
                    if (dfs(next)) return true;
                }
            }
        }
        return false;
    }
    
    private List<Double> combineElements(double i, double j) {
        List<Double> res = new ArrayList<>();
        res.add(i + j);
        res.add(i - j);
        res.add(j - i);
        res.add(i * j);
        res.add(i / j);
        res.add(j / i);
        return res;
    }
}
// @lc code=end

