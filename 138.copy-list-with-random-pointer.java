/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
/*
按顺序插入相同val的值作为copy,此时cur就是当前list中的node, cur.next就是copy list中的node
eg: 7   13    11    10    1    null
     \/    \/    \/    \/   \/
      7    13    11    10    1
time: O(n)
extra space: O(1)
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node dummy = new Node(0);
        Node copy = dummy;
        cur = head;
        while (cur != null) {
            copy.next = cur.next;
            cur.next = cur.next.next;
            copy = copy.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end

