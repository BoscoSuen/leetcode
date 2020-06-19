/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start

/*
hashTable + Treeset
利用一个long tick变量模拟时钟，对于每一个key-value, 利用一个Node{key, val, freq, tick}来储存
对于一个node将其插入一个balanced search tree中(用TreeSet实现), evict的时候去掉TreeSet第一个元素
update的时候需要先把node从tree中移除再重新插入
time: get O(log capacity) put O(log capacity)
space: O(capacity)
*/
class LFUCache {
    class Node implements Comparable<Node>{
        int key;
        int val;
        int freq;
        long tick;
        public Node(int key, int val, int freq, long tick) {
            this.key = key;
            this.val = val;
            this.freq = freq;
            this.tick = tick;
        }

        // freq最小, tick最小的会被evict
        @Override
        public int compareTo(Node n) {
            if (this.freq != n.freq) return this.freq - n.freq;
            return (int)(this.tick - n.tick);
        }
    }
    long tick = 0;
    int capacity;
    Map<Integer, Node> map;
    TreeSet<Node> set;
    public LFUCache(int capacity) {
        map = new HashMap<>();
        set = new TreeSet<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        update(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            update(cur);
        } else {
            if (set.size() == capacity) {
                Node first = set.first();
                map.remove(first.key);
                set.pollFirst();
                // set.remove(first);
            }
            Node newNode = new Node(key, value, 1, ++tick);
            map.put(key, newNode);
            set.add(newNode);
        }
    }

    private void update(Node cur) {
        set.remove(cur);
        cur.freq++;         // 注意: 一定要先remove object再update cur,否则remove时找不到object, add时会copy一个新的
        cur.tick = ++tick;      // 模拟时钟记时
        set.add(cur);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

