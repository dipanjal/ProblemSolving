// Leetcode: 138 | Reorder Linked List
// Difficulty: Medium
// Description: https://leetcode.com/problems/reorder-list/description/
// Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/reorder-linked-list/


class Solution {
    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    private ListNode getNodeBeforeMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null and fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head) {
        ListNode left = null;
        ListNode right = head;
        while (right != null) {
            ListNode rightNext = right.next;
            right.next = left;
            left = right;
            right = rightNext;
        }
        return left;
    }
    public void getNodeBeforeMiddle(ListNode head) {
        if (head == null) 
            return null;
        // find the node before middle node.
        // because we want to split the list into two lists
        ListNode beforeMid = this.getNodeBeforeMiddle(head);
        // now we get the head of the second list
        ListNode secHead = beforeMid.next;
        // lets break the link between two parts of the list
        // splitting the linked list into two lists
        beforeMid.next = null;
        // reverse the second half of the list
        ListNode secHeadRev = this.reverseList(secHead);
        // now reorder the list. place two pointers at the beginning of the lists
        ListNode p1 = head;
        ListNode p2 = secHeadRev;
        while (p2 != null) {
            p1Next = p1.next;
            p2Next = p2.next;

            p1.next = p2;
            p2.next = p1Next;

            p1 = p1Next;
            p2 = p2Next;
        }

    }
}