/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    O(1) space的merge sort解
    遍历merge的时候，利用step = 1开始 step <<= 1来进入到下一次遍历
    第一次merge前两个node, 利用一个指针指到第三个node,并和之前的部分split, 然后merge第3,4个...,第一层结束后step = 2
    最后一次的step = length / 2,所以要先遍历一次链表的长度
    在遍历merge的过程还需要一个prev指针指向待merge部分的前一个node(即当前两个merge部分的dummy)
    space: O(1)
    */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        for (int i = 1; i < n; i <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(cur, i);
                cur = split(right, i); // could be null
                prev = merge(prev, left, right);
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode head, int count) {
        if (head == null) return null;
        for (int i = 1; head.next != null && i < count; ++i) {
            head = head.next;
        }
        ListNode nextHead = head.next;
        head.next = null;
        return nextHead;
    }

    private ListNode merge(ListNode prev, ListNode l1, ListNode l2) {
        ListNode cur = prev;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        while (cur.next != null) cur = cur.next;
        return cur;
    }
}
// @lc code=end

