/**
 * Leetcode 142 | Linked List Cycle II
 * Problem: https://leetcode.com/problems/linked-list-cycle-ii/description/
 * Difficulty: Medium
 */

#include <iostream>
#include <cstddef>

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
  
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        // first need to confirm that the linked list has a cycle
        // explanation for linked list cycle detection
        // https://dipanjals-notebook.vercel.app/leetcode/linked-list/linked-list-cycle/
        // this is the prerequisite one
        bool has_cycle = false;

        ListNode *slow = head;
        ListNode *fast = head;
        while (fast != NULL && fast->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) {
                has_cycle = true;
                break;
            }
        }
        
        // If there is no cycle, return null.
        if (!has_cycle) {
            return NULL;
        }

        // at this point we are sure that the linked list has a cycle. 
        // let's find the begining node where the cycle has started
        ListNode *curr = head;

        // we know that at some point curr and slow will meet eachother,
        // according to the Floyed's algorithm 
        // the loop will stop when both of the pointers meet with eachother
        // and the meeting point is the begining of the cycle
        while (curr != slow) {
            curr = curr->next;
            slow = slow->next;
        }
        return curr;
    }
};