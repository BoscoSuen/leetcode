/*
 * @lc app=leetcode id=24 lang=cpp
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr || head->next == nullptr) return head;
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* prev = dummy;
        ListNode* cur = head;

        while (cur && cur->next) {
            ListNode* temp = cur->next;
            cur->next = temp->next;
            prev->next = temp;
            temp->next = cur;
            prev = cur;
            cur = cur->next;
        }
        return dummy->next;
    }
};
// @lc code=end

