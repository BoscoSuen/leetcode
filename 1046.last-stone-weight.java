/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    /*
    max heap
    time: O(nlogn)
    space: O(n)
    */
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int l1 = pq.poll(), l2 = pq.poll();
            if (l1 > l2) pq.offer(l1 - l2);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
// @lc code=end

