/*
 * @lc app=leetcode id=732 lang=java
 *
 * [732] My Calendar III
 */

// @lc code=start
/*
思路同calendar II, TreeMap+count
time: O(n^2) traverse O(n)
space: O(n)
*/
class MyCalendarThree {
    TreeMap<Integer, Integer> map;
    int max = 0;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            max = Math.max(max, count);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
// @lc code=end

