/*
 * @lc app=leetcode id=731 lang=java
 *
 * [731] My Calendar II
 */

// @lc code=start

/*
用treeMap来记录区间的start position和一个对应的count指针
对于start，对应的count+1，对于end，对应的count-1
从count=0开始遍历所有map entry,如果一直有start进来count+1而没有遇到count-1的end position，就会出现count>2的triple booking
time: O(n^2) each traverse in O(n)
space: O(n)
*/
class MyCalendarTwo {
    TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count > 2) {
                map.put(start, map.get(start) - 1);
                if (map.get(start) == 0) map.remove(start);
                map.put(end, map.get(end) + 1);
                if (map.get(end) == 0) map.remove(end);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

