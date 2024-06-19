// Leetcode 25 | Reverse Node in K Group
// Difficulty: Hard
// Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
// Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reverse-nodes-in-k-group/


//  Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private ListNode getKthNode(ListNode ptr, int k) {
        while (ptr != null && k > 0) {
            ptr = ptr.next;
            k--;
        }
        return ptr;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prevTail = dummy;
        while (true) {
            ListNode kthNode = this.getKthNode(prevTail, k);
            if (kthNode == null) {
                // all the k groups have reversed
                break;
            }
            ListNode nextGroupHead = kthNode.next;
            ListNode curr = prevTail.next;
            ListNode prev = nextGroupHead;
            
            // reverse current group
            while (curr != nextGroupHead) {
                ListNode currNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = currNext;
            }
            // current group has reversed
            // but the prevTail is still connected to the old head
            // let's reconcile the prevTail with new head
            
            // before modifying the next pointer, need to save it in a temp veriable
            ListNode nextPrevTail = prevTail.next;
            
            // connect prevTail with new head.
            // after reversing kthNode is the new head
            prevTail.next = kthNode;

            // move prevTail to the new Tail of the current group,
            // because we need to reverse the next group
            prevTail = nextPrevTail;
        }
        return dummy.next;
    }

    // This part of code is necessary when you want to run this code in your local machine
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        printList(head);

        Solution solution = new Solution();
        int k = 2;
        head = solution.reverseKGroup(head, k);

        System.out.println("Reversed list in k-groups:");
        printList(head);
    }
}