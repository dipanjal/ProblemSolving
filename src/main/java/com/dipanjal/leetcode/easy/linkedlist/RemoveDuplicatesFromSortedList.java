package com.dipanjal.leetcode.easy.linkedlist;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode walker = new ListNode(-1);
        walker.next = head;
        ListNode runner = walker.next;

        while(runner != null) {
            if(walker.val == runner.val) {
                walker.next = runner.next;
            }else {
                walker = walker.next;
            }
            runner = runner.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null) return null;

        ListNode runner = head;

        while(runner.next != null) {
            if(runner.val == runner.next.val) {
                runner.next = runner.next.next;
            }else {
                runner = runner.next;
            }
        }
        return head;
    }

    private static void travarse(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(3,
                                                        new ListNode(3)))))
        );

        ListNode newHead = new RemoveDuplicatesFromSortedList()
                .deleteDuplicates2(head);

        travarse(newHead);

    }
}
