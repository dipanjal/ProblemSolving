/**
 * Leetcode 19 | Remove Nth Node From End of List
 * Difficulty: Medium
 * Description: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/remove-nth-node-from-end-of-the-list/
 */

#include <iostream>
using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode(-1, head);
        ListNode* left = dummy;
        ListNode* right = head;
        while (n > 0 and right != NULL) {
            right = right->next;
            n--;
        }
        while (right != NULL) {
            left = left->next;
            right = right->next;
        }
        left->next = left->next->next;
        return dummy->next;
    }
};