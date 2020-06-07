/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    /*
    利用一个最大堆维护左半边，最小堆维护右半边
    time: O(logn)
    space: O(n)
    */
    PriorityQueue<Integer> minH;  // the larger part
    PriorityQueue<Integer> maxH;  // the smaller part
    /** initialize your data structure here. */
    public MedianFinder() {
        minH = new PriorityQueue<>();
        maxH = new PriorityQueue<>((a, b) -> (b - a));
    }
    
    public void addNum(int num) {
        if (maxH.isEmpty() || num < maxH.peek()) {
            maxH.offer(num);
        } else {
            minH.offer(num);
        }
        if (maxH.size() - minH.size() > 1) {
            minH.offer(maxH.poll());
        }
        if (minH.size() - maxH.size() > 1) {
            maxH.offer(minH.poll());
        }
    }
    
    public double findMedian() {
        if (maxH.size() == minH.size()) {
            return 0.5 * (maxH.peek() + minH.peek());
        } else {
            return maxH.size() > minH.size() ? maxH.peek() : minH.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

