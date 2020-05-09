/*
 * @lc app=leetcode id=862 lang=java
 *
 * [862] Shortest Subarray with Sum at Least K
 */

// @lc code=start
class Solution {
    /*
    To handle negative elements, we cannot use normal sliding window, like 
    [84,-37,32,40,95], K = 167, we can never get the left window slide
    instead, we need to use monotonic queue sliding window
    in the queue, we add the index of the array and make the value monotonic
    Basic Idea: find the smallest j that B[j] - B[i] >= K
    * to handle the negative element, when find a prefix sum is smaller, we remove all the number in the deque that is larger than current prefix sum
    * to make the queue monotonic,eg: [84,-37,32,40,95], prefix: 84, 47, we remove 84
    * when get sum in the following iteration, we just get the first element 47
    time: O(n)
    space: O(n)
    */
    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) return -1;
        int[] prefix = new int[A.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < A.length; ++i) {
            prefix[i + 1] = prefix[i] + A[i];
        }
        // prefix[i] - prefix[j] = sum[i,j)
        int res = Integer.MAX_VALUE;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < A.length + 1; ++i) {
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= K) {
                res = Math.min(res, i - dq.pollFirst());
                // use pollFirst to remove the first small elment used and keep going to remove all the small element
                // eg: [17, 85, 93, -45, -21]
            }
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
// @lc code=end

