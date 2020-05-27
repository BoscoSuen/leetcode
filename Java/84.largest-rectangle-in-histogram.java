/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    /*
    monotonic stack
    木桶原理：维护一个单调递增栈，如果当前高度小于栈顶高度，将高的部分的index都取出来，此时这一部分一定可以组成一个矩形
    2 1 5 6 2 3
    遇到1<2时，index [0,1)一定可以组成矩形(不包括当前高度，因为当前高度低)，area = 1,然后将1push进stack,直到1 5 6
    遇到2<6时，将6，5分别pop, area = 6 * 1, area = 5 * 2, 计算面积的高度一定是当前stack的栈顶高度(单调）
    注意, 如果最小高度在中间的话，最后一次单调计算面积时要保证宽度覆盖整个宽度，可以一开始在stack前push一个-1,
    判断empty的时候也要看stack.peek()是不是-1
    eg:[2 1 2] max =3
    这样计算宽度的时候可以统一用（i - 栈顶前一个位置 - 1）
    维护最大的area
    time: O(N) 所有元素最多处理2次(push & pop)
    space: O(n)
    */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        // 在heights末尾加一个0来处理单调递增的情况
        for (int i = 0; i <= heights.length; ++i) {
            int h = i == heights.length ? 0 : heights[i];
            while (stack.peek() != -1 && h < heights[stack.peek()]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return max;
    }
}
// @lc code=end

