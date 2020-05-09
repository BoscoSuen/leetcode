/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    先成环，找到需要断开的位置，再断开，注意断开的位置要置null
    time: O(n)
    space: O(1)
    */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode n = head;
        while (n != null) {
            n = n.next;
            len++;
        }
        k %= len;
        if (k == 0) return head;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;    // get a cycle
        for (int i = 0; i < len - k; ++i) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }
}
// @lc code=end

