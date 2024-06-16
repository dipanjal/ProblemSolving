/**
 * Leeocode 141 | Linked List Cycle
 * Problem: https://leetcode.com/problems/linked-list-cycle/description/
 * Difficulty: Medium
 * Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/linked-list-cycle/
 */

#include <iostream>
#include <cstddef>
using namespace std;

//  Definition for singly-linked list.
 struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode *slow = head;
        ListNode *fast = head;
        while (fast != NULL && fast->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
};

int main() {
    // Create nodes
    ListNode* head = new ListNode(3);
    ListNode* node2 = new ListNode(2);
    ListNode* node0 = new ListNode(0);
    ListNode* node4 = new ListNode(-4);

    // Connect nodes to form a cycle: 3 -> 2 -> 0 -> -4 -> 2
    head->next = node2;
    node2->next = node0;
    node0->next = node4;
    node4->next = node2; // Cycle here

    // Detect cycle
    Solution solution;
    bool has_cycle = solution.hasCycle(head);

    if (has_cycle) {
        cout << "Cycle detected" << endl;
    } else {
        cout << "No cycle detected" << endl;
    }

    // Clean up memory (Note: in a real-world scenario, you should carefully manage memory, especially with cycles)
    delete head;
    delete node2;
    delete node0;
    delete node4;

    return 0;
}