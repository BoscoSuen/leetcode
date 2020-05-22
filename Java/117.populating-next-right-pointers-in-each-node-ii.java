/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    /*
    用一个dummy指针指向当前层，按照链表append的方式组装next
    time: O(n)
    space: O(1)
    */
    public Node connect(Node root) {
        if (root == null) return root;
        Node cur = root;
        Node dummy = new Node(0);
        Node p = dummy;
        while (cur != null) {
            if (cur.left != null) {
                p.next = cur.left;
                p = p.next;
            }
            if (cur.right != null) {
                p.next = cur.right;
                p = p.next;
            }
            if (cur.next != null) {
                cur = cur.next;
            } else {
                cur = dummy.next;
                p = dummy;
                dummy.next = null;
            }
        }
        return root;
    }
}
// @lc code=end

