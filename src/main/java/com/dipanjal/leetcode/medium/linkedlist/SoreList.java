package com.dipanjal.leetcode.medium.linkedlist;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class SoreList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*public ListNode sortList(ListNode head) {
        if(head == null) return head;
    }*/

    public static void main(String[] args) {
        ListNode head = new ListNode(10, new ListNode(4, new ListNode(15,
                new ListNode(1, new ListNode(2, new ListNode(12, new ListNode(54)))))));

    }
}
