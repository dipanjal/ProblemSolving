/**
 * Leetcode 206 | Reverse Linked List (recursive approach)
 * Difficulty: Easy
 * Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reverse-a-linked-list-recursive/
 */


public class Solution {
    
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode revHead = head;
        if (head.next != null) {
            revHead = reverseList(head.next);
            ListNode rightNode = head.next;
            rightNode.next = head;
        }
        head.next = null;
        return revHead;
    }

    // Function to print the linked list
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    // Function to create a linked list from an array of values
    public ListNode createLinkedList(int[] values) {
        if (values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    // Main function
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Create a linked list from an array of values
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = sol.createLinkedList(values);

        System.out.println("Original list:");
        sol.printList(head);

        // Reverse the linked list
        ListNode reversedHead = sol.reverseList(head);

        System.out.println("Reversed list:");
        sol.printList(reversedHead);
    }
}
