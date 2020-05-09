/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    将所有小于给定值的节点取出组成一个新的链表，此时原链表中剩余的节点的值都大于
    或等于给定值，只要将原链表直接接在新链表后即可
    time: O(n)
    space: O(1)
    */
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode dummy1 = new ListNode(0);
        dummy1.next = head;
        ListNode dummy2 = new ListNode(0);
        ListNode cur = dummy1;
        ListNode pos = dummy2;
        while (cur.next != null) {
            if (cur.next.val < x) {
                pos.next = cur.next;
                cur.next = cur.next.next;
                pos = pos.next;
            } else {
                cur = cur.next;
            }
        }
        pos.next = dummy1.next;
        return dummy2.next;
    }
}
// @lc code=end

