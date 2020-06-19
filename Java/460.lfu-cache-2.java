/*
 * @lc app=leetcode id=460 lang=java
 *
 * [460] LFU Cache
 */

// @lc code=start

/*
2 HashMap + Doubly LinkedList
将key和Node{key, val, freq}利用一个map联系起来，对于每一个freq，我们维护一个DList, 
其中DList实现了类似LRU cache的功能，对于某个freq, 新来的加入到list的最前面
如果某一个key freq+1，该node从原freq的list中remove,再加入到新的list中
对于least freq, 利用一个全局变量minFreq来track
eg:
freq = k keyk
...
freq = 2 key3
freq = 1 key1 <-> key 2        => minFreq

key1 freq + 1:
freq = k keyk
...
freq = 2 key1 <-> key3
freq = 1 key 2        => minFreq
time: O(1)
space: O(capacity)
*/
class LFUCache {
    class Node{
        int key;
        int val;
        int freq;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
            next = null;
            prev = null;
        }
    }

    class DList{
        Node head;
        Node tail;
        int size;
        public DList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            size = 0;
            head.next = tail;
            tail.prev = head;
        }
        public void addToHead(Node node) {
            Node temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
            nodeMap.put(node.key, node);
            size++;
        }
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            nodeMap.remove(node.key);
            size--;
        }
        public void popTail() {
            remove(tail.prev);
        }
        public boolean isEmpty() {
            return size == 0;
        }
    }

    Map<Integer, Node> nodeMap;
    Map<Integer, DList> freqMap;
    int minFreq = 1;
    int capacity;
    int size = 0;       // count for all nodes
    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node cur = nodeMap.get(key);
        update(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;  // corner case
        if (nodeMap.containsKey(key)) {
            Node cur = nodeMap.get(key);
            cur.val = value;
            update(cur);
            return;
        }
        if (size == capacity) {
            while (freqMap.get(minFreq).isEmpty()) minFreq++;
            freqMap.get(minFreq).popTail();
            size--;
        }
        Node newNode = new Node(key, value);
        minFreq = 1;
        freqMap.putIfAbsent(minFreq, new DList());
        freqMap.get(minFreq).addToHead(newNode);
        size++;
    }

    private void update(Node cur) {
        int freq = cur.freq;
        freqMap.get(freq).remove(cur);
        if (freqMap.get(freq).isEmpty() && freq == minFreq) {
            freqMap.remove(freq);
            minFreq++;
        }
        cur.freq++;
        freqMap.putIfAbsent(cur.freq, new DList());
        freqMap.get(cur.freq).addToHead(cur);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

