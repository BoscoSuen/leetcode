/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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
    track前一个node和第一个node,把第二个node标记成temp,然后进行交换
    d     1    2   3  4
    prev cur temp
    先连接cur和下一对的第一个(3), 然后再交换内部的连接顺序
    time: O(n)
    space: O(1)
    */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            prev.next = temp;
            temp.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end

