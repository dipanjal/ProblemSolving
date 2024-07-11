/**
 * Leetcode 206 | Reverse Linked List
 * Difficulty: Easy
 * Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reverse-a-linked-list/
 */

class Solution {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        return prev;
    }
}