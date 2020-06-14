/*
 * @lc app=leetcode id=622 lang=java
 *
 * [622] Design Circular Queue
 */

// @lc code=start
/*
利用一个数组，标记其中的front和left指针，以及当前queue size
enqueue的时候在not full的时候更新rear指针,dequeue的时候在not empty的情况下更新front指针
time: O(1)
*/
class MyCircularQueue {
    int[] queue;
    int front = 0, rear = -1, size = 0, capacity = 0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (!this.isFull()) {
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            return true;
        } else return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (!this.isEmpty()) {
            front = (front + 1) % capacity;
            size--;
            return true;
        } else return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return this.isEmpty() ? -1 : queue[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return this.isEmpty() ? -1 : queue[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

