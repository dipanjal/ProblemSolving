// Leetcode 25 | Reverse Node in K Group
// Difficulty: Hard
// Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reverse-nodes-in-k-group/

#include <iostream>
#include <cstddef>
using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(NULL) {}
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
private:
    ListNode* getKthNode(ListNode* ptr, int k) {
        while (ptr != NULL && k > 0) {
            ptr = ptr->next;
            k--;
        }
        return ptr;
    }
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* dummy = new ListNode(-1, head);
        ListNode* prevTail = dummy;
        while(true) {
            ListNode* kthNode = getKthNode(prevTail, k);
            if (kthNode == NULL) {
                // all the groups have reversed
                break;
            }
            ListNode* nextGroupHead = kthNode->next;
            ListNode* curr = prevTail->next;
            ListNode* prev = nextGroupHead;
            // Reverse
            while(curr != nextGroupHead) {
                ListNode* currNext = curr->next;
                curr->next = prev;
                prev = curr;
                curr = currNext;
            }
            // current group is reversed
            // prevTail is still connected to the old head
            // Reconcile PrevTail next pointer
            ListNode* nextPrevTail = prevTail->next;
            // because KthNode is the new head
            prevTail->next = kthNode;
            // moving prevTail to the nextPrevTail, because we need to reverse the next K group 
            prevTail = nextPrevTail;

        }
        // all the groups have reversed
        return dummy->next;
    }
};

void printList(ListNode* head) {
    while (head) {
        cout << head->val << " -> ";
        head = head->next;
    }
    cout << "nullptr" << endl;
}

int main() {
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);
    
    cout << "Original list:" << endl;
    printList(head);
    
    int k = 2;
    Solution solution;
    head = solution.reverseKGroup(head, k);
    
    cout << "Reversed list in k-groups:" << endl;
    printList(head);
    
    return 0;
}