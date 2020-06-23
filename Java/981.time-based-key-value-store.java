/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start

/*
由于timeStamp是递增的，可以利用HashMap + binary search或Map<key, TreeMap<time, val>>来实现
HashMap + binary search: find the lowest val that > timestamp, return val - 1
time: set O(1) get: O(logn)
space: O(n)
*/

class TimeMap {
    class Data {
        String val;
        int time;
        public Data(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }
    Map<String, List<Data>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Data> list = map.get(key);
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid).time > timestamp) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == 0 ? "" : list.get(left - 1).val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

