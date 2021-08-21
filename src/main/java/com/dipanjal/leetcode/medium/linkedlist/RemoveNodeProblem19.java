package com.dipanjal.leetcode.medium.linkedlist;

/**
 * @author dipanjal
 * @since 0.0.1
 *
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class RemoveNodeProblem19 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private int getSize(ListNode head){
        int currIndex = 0;
        while(head != null) {
            head = head.next;
            currIndex++;
        }
        System.out.println("Size: "+ currIndex);
        return currIndex;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = head;
        int lastIndex = getSize(head);
        int nthNode = (lastIndex - n);
        ListNode prevNode = null;
        int count = 0;
        while(head != null) {
            if(count == nthNode - 1){
                prevNode = head;
            }
            if(count == nthNode){
                if(prevNode != null){
                    prevNode.next = head.next;
                    head.next = null;
                }
                System.out.printf("[%d] -> [%d]%n", count, head.val);
            }
            head = head.next;
            count++;
        }
        System.out.println("-------------------------");
        return dummyHead;
    }

    /**
     * Optimal Solution: Two Pointer Approach
     */
    public ListNode removeNthFromEndTwoPointer(ListNode head, int n){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        /**
         * while the slow is stopped
         * Move the Fast pointer right before the Node to be deleted;
         */
        for(int i=1; i<=n+1; i++){
            fast = fast.next;
            System.out.printf("[%d] -> [%d]%n", i, fast.val);
        }

        /**
         * now move the slow until the fast is null.
         * means the slow must be pointed to the previous element of the nore
         * once we have find it, unlink the previous to the slow.next.next
         */
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
