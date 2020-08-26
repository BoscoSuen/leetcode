/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    将链表对半分，reverse后一半，再merge list]
    time: O(n)
    space: O(1)
    */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow.next;
        slow.next = null;
        p = reverse(p);

        ListNode cur = head;
        while (p != null) {
            ListNode temp = cur.next;
            ListNode nextP = p.next;
            cur.next = p;
            p.next = temp;
            cur = temp;
            p = nextP;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode temp = head.next;
            ListNode tempNext = dummy.next;
            dummy.next = head;
            head.next = tempNext;
            head = temp;
        }
        return dummy.next;
    }
}
// @lc code=end

