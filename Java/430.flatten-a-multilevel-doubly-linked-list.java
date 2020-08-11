/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    /*
    一层一层的遍历，找到child节点后在中间插入下一层
    time: O(n)
    space: O(1)
    */
    public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            if (cur.child == null) {
                cur = cur.next;
            } else {
                // 把当前层加到p和p.next中间
                Node child = cur.child;
                while (child.next != null) {
                    child = child.next;
                }
                child.next  = cur.next;
                if (cur.next != null) cur.next.prev = child;
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
        }
        return head;
    }
}
// @lc code=end

