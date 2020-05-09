/*
 * @lc app=leetcode id=846 lang=java
 *
 * [846] Hand of Straights
 */

// @lc code=start
class Solution {
    /*
    * follow up见discussion: https://leetcode.com/problems/hand-of-straights/discuss/135598/C%2B%2BJavaPython-O(MlogM)-Complexity
    利用TreeMap统计牌的次数并排序,遍历能组成顺子的W张牌，若没有直接返回false，有的话，则映射值减去start的count(避免重复遍历Key)，若映射值为0了，则从 TreeMap 中移除该映射
    time: O(nlogn)
    space: O(n)
    */
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length % W != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 最好不要用dynamic cast, map中没有fisrtkey()
        for (int h : hand) map.put(h, map.getOrDefault(h, 0) + 1);
        while (!map.isEmpty()) {
            int start = map.firstKey();
            int count = map.get(start);
            for (int i = 0; i < W; ++i) {
                if (!map.containsKey(start + i)) return false;
                int nextCount = map.get(start + i);
                if (nextCount < count) return false;
                if (nextCount == count) map.remove(start + i);
                else map.put(start + i, nextCount - count);
            }
        }
        return true;
    }
} 
// @lc code=end

