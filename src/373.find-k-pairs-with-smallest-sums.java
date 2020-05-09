/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lc code=start
import java.util.*;
class Solution {
    /*
    利用Priority Queue，先储存每个nums1元素和nums2[0]的index，
    再poll出一组元素的时候，将当前nums1 index和nums2 index+1的元素进行结合，
    加入到queue中，重复该过程，得到k个输出的结果
    time: O(klogk)
    space: O(n)
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]));
        for (int i = 0; i < nums1.length; ++i) {
            pq.offer(new int[]{i, 0});
        }
        while (!pq.isEmpty() && k-- > 0) {
            int[] cur = pq.poll();
            List<Integer> curList = new ArrayList<>();
            curList.add(nums1[cur[0]]);
            curList.add(nums2[cur[1]]);
            res.add(curList);
            if (cur[1] < nums2.length - 1) {
                pq.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        return res;
    }
}
// @lc code=end

