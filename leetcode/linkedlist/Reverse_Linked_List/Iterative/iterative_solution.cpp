/**
 * Leetcode 206 | Reverse Linked List
 * Difficulty: Easy
 * Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reverse-a-linked-list-recursive/
 */

#include <iostream>
using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL) {
            return NULL;
        }
        
        ListNode* revHead = head;
        if (head->next != NULL) {
            revHead = reverseList(head->next);
            // Reverse Pair of Node
            ListNode* rightNode = head->next;
            rightNode->next = head;
        }
        // This Head is now Tail,
        // So connect the Tail with NULL
        head->next = NULL;
        return revHead;
    }
};