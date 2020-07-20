/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start

/*
利用一个TreeMap来储存<start, end>
利用map.floorKey来找到start之前的时间段end是否冲突
再利用map.ceilingKey来找到start之后的起始时间end是否冲突
time: O(logn)
space: O(n)
*/
class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if (prev != null && map.get(prev) > start || next != null && next < end) {
            return false;
        }
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

