#include <iostream>
#include <vector>
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

// Function to print the linked list
void printList(ListNode* head) {
    ListNode* curr = head;
    while (curr != NULL) {
        cout << curr->val << " -> ";
        curr = curr->next;
    }
    cout << "NULL" << endl;
}

// Function to create a linked list from a vector of values
ListNode* createLinkedList(const vector<int>& values) {
    if (values.empty()) {
        return NULL;
    }
    ListNode* head = new ListNode(values[0]);
    ListNode* curr = head;
    for (int i = 1; i < values.size(); i++) {
        curr->next = new ListNode(values[i]);
        curr = curr->next;
    }
    return head;
}

// Main function
int main() {
    // Create a linked list from a vector of values
    vector<int> values = {1, 2, 3, 4, 5};
    ListNode* head = createLinkedList(values);
    
    cout << "Original list:" << endl;
    printList(head);
    
    // Reverse the linked list
    Solution sol;
    ListNode* reversed_head = sol.reverseList(head);
    
    cout << "Reversed list:" << endl;
    printList(reversed_head);
    
    return 0;
}
