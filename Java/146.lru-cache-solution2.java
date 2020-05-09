/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
/*
LinkedHashMap:
constructor : (int initial capacity, float load factor, boolean accessorder)
load factor: load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased. 
    When the number of entries in the hash table exceeds the product of the load factor and the current capacity, the hash table is rehashed (that is, 
    internal data structures are rebuilt) so that the hash table has approximately twice the number of buckets.
    default load factor (.75) offers a good tradeoff between time and space costs.
order: order in which keys were inserted into the map (insertion-order), from least recently -> most recently
re-insert key will not affect the order
* It is not syschronized, Map m = Collections.synchronizedMap(new LinkedHashMap(...));
*/
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
