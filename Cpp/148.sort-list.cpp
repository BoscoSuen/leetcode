/*
 * @lc app=leetcode id=148 lang=cpp
 *
 * [148] Sort List
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
    merge sort
    time: O(nlogn)
    space: O(n)
    */
public:
    ListNode* sortList(ListNode* head) {
        if (!head || !(head->next)) return head;
        ListNode* middle = getMid(head);
        ListNode* next = middle->next;
        middle->next = nullptr;
        return merge(sortList(head), sortList(next));
    }

private:
    ListNode* getMid(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head->next;    // mid在中点或中点偏左
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }

    ListNode* merge(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode(0);
        ListNode* cur = dummy;
        while (l1 && l2) {
            if (l1->val <= l2->val) {
                cur->next = l1;
                l1 = l1->next;
            } else {
                cur->next = l2;
                l2 = l2->next;
            }
            cur = cur->next;
        }
        if (l1 != nullptr) cur->next = l1;
        else if (l2 != nullptr) cur->next = l2;
        return dummy->next;
    }
};
// @lc code=end

