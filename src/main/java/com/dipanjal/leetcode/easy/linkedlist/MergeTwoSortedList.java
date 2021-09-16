package com.dipanjal.leetcode.easy.linkedlist;

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode runner = new ListNode(-1);
        ListNode newHead = runner;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val){
                runner.next = l1;
                l1 = l1.next;
            }else {
                runner.next = l2;
                l2 = l2.next;
            }
            runner = runner.next;
        }

        /** Now collect the reminders if has */
        /* means: L1 Has some nodes remains to be collected */
        if(l1 != null)
            runner.next = l1;

        /* means: L2 Has some nodes remains to be collected */
        if(l2 != null)
            runner.next = l2;

        return newHead.next; //because we want to ignore the initial dummyHead -1
    }
}
