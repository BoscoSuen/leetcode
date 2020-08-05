/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 */

// @lc code=start

/*
取base = 997(prime number), 建立bucket数组, 每个bucket对应一个linkedList(remove时间是O(1))
如果遇到collision, 添加元素到对应list末尾
time: O(n)  n:size of the linkedlist
*/
class MyHashSet {
    List<Integer>[] buckets;
    int base = 997;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new LinkedList[base];
    }
    
    public void add(int key) {
        int pos = hashing(key);
        if (buckets[pos] == null) {
            buckets[pos] = new LinkedList<>();
        }
        if (buckets[pos].indexOf(key) == -1) {
            buckets[pos].add(key);
        }
    }
    
    public void remove(int key) {
        int pos = hashing(key);
        if (buckets[pos] != null) {
            int index = buckets[pos].indexOf(key);
            if (index != -1) {
                buckets[pos].remove(index);
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int pos = hashing(key);
        if (buckets[pos] != null) {
            return buckets[pos].indexOf(key) != -1;
        }
        return false;
    }
    
    private int hashing(int num) {
        return num % base;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

