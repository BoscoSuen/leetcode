/*
 * @lc app=leetcode id=706 lang=java
 *
 * [706] Design HashMap
 */

// @lc code=start
class MyHashMap {
    /*
    利用已知的size = 10000建立一个size = 10001的bucket数组
    用Integer.hashCode()生成hash, 用linkedlist来处理hash collision的情况
    为了处理remove的情况，可以在对应的bucket加一个dummy node
    可以修饰key为final保证不会被改变
    */
    class Node {
        final int key;
        int val;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    final int SIZE = 10001;
    Node[] bucket;
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new Node[SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int pos = getHash(key);
        if (bucket[pos] == null) {
            bucket[pos] = new Node(-1, -1);
        }
        Node prev = bucket[pos];
        while (prev.next != null) {
            if (prev.next.key == key) {
                prev.next.val = value;
                return;
            }
            prev = prev.next;
        }
        prev.next = new Node(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int pos = getHash(key);
        if (bucket[pos] == null) return -1;
        Node prev = bucket[pos];
        while (prev.next != null) {
            if (prev.next.key == key) {
                return prev.next.val;
            }
            prev = prev.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int pos = getHash(key);
        if (bucket[pos] == null) return;
        Node prev = bucket[pos];
        while (prev.next != null) {
            if (prev.next.key == key) {
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
        }
    }

    private int getHash(int key) {
        return Integer.hashCode(key) % SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

