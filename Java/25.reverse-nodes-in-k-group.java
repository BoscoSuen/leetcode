/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    只要 cur 走过k个节点，那么 next 就是 cur->next，就可以调用翻转函数来进行局部翻转了，
    注意翻转之后新的 cur 和 pre 的位置都不同了，那么翻转之后，cur 应该更新为 pre->next，
    而如果不需要翻转的话，cur 更新为 cur->next
    time: O(n)
    space: O(1)
    */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, cur = head;
        for (int i = 1; cur != null; ++i) {
            if (i % k == 0) {
                prev = reverse(prev, cur.next); // prev not included, cur included
                cur = prev.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode prev, ListNode end) {
        ListNode cur = prev.next;
        while (cur.next != end) {
            // p 1 2 3 end
            // p 2 1 3 end
            // p 3 2 1 end   cur always 1
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return cur;
    }
}
// @lc code=end

