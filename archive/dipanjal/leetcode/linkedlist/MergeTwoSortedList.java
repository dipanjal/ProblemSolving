package com.dipanjal.leetcode.linkedlist;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * easy
 */
public class MergeTwoSortedList {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        /** Now collect the reminders if has */
        /* means: L1 Has some nodes remains to be collected */
        if(l1 != null)
            tail.next = l1;

        /* means: L2 Has some nodes remains to be collected */
        if(l2 != null)
            tail.next = l2;

        return newHead.next; //because we want to ignore the initial dummyHead -1
    }

    public static void travarse(ListNode head) {
        while(head != null) {
            String arrow = head.next != null ? "->" : "";
            System.out.print(head.val+arrow);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode merged = mergeTwoLists(l1, l2);
        travarse(merged);
    }
}
