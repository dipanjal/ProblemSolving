package com.dipanjal.leetcode.easy.linkedlist;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode middleNode(ListNode head) {
        if(head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void traverse(ListNode head) {
        while(head != null) {
            String arrow = head.next != null ? "->" : "";
            System.out.print(head.val+arrow);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10, new ListNode(4, new ListNode(15,
                new ListNode(1, new ListNode(2, new ListNode(12))))));

        ListNode mid = middleNode(head);

        traverse(mid);
    }
}
