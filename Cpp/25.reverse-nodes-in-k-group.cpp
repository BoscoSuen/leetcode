/*
 * @lc app=leetcode id=25 lang=cpp
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
/*
recursion
time: O(n)
space: O(n)
*/
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (head == nullptr || head->next == nullptr) return head;
        int count = 0;
        ListNode* cur = head;
        while (cur != nullptr && count < k) {
            count++;
            cur = cur->next;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (k-- > 0) {
                ListNode* prev = head->next;
                head->next = cur;
                cur = head;
                head = prev;
            }
            head = cur;
        }
        return head;
    }
};
// @lc code=end

