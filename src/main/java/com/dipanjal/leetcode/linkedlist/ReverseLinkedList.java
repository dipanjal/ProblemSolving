package com.dipanjal.leetcode.linkedlist;

import com.dipanjal.common.LinkList;
import com.dipanjal.common.LinkList.Node;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class ReverseLinkedList {

    private static void print(Node<Integer> head){
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    /*public static Node<Integer> reverseList1(Node<Integer> head) {
        Deque<Node<Integer>> stack = new ArrayDeque<>();
        while(head != null) {
            stack.push(head);
            head = head.next;
        }

        head = stack.pop();
        Node<Integer> curr = head;
        while(!stack.isEmpty()) {
//            Node<Integer> next = stack.pop();
            head.next = stack.pop();
            curr = head.next;
//            revHead = head.next;
//            if(stack.isEmpty())
//                revHead.next = null;
        }

        return head;
    }*/

    /**
     * Optimal Solution
     * TC: O(n) | SC O(1)
     * @param head
     * @return
     * 1 <- 2 <- 3 <- 4
     */
    public static Node<Integer> reverseList2(Node<Integer> head) {
        Node<Integer> revHead = head;
        Node<Integer> curr = revHead.next;
        revHead.next = null;
        while(curr != null) {
            Node<Integer> cNext = curr.next;
            curr.next = revHead;
            revHead = curr;
            curr = cNext;
        }
        return revHead;
    }

    // recursive
    /*public ListNode reverseList(ListNode head) {

        if(head == null) return null;
        if(head.next == null) {
            return head;
        }
        ListNode ptr = reverseList(head.next);
        head.next = null;

        insertAtEnd(ptr,head);
        return ptr;

    }

    private static void insertAtEnd(ListNode ptr, ListNode node) {
        ListNode p = ptr;
        while(p.next != null) {
            p = p.next;
        }
        p.next = node;
    }*/

    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.insert(new Integer[]{1,2,3,4,5});
        System.out.println("----------- Before -----------");
        print(linkList.head);
        Node<Integer> revHead = reverseList2(linkList.head);
        System.out.println("----------- After ------------");
        print(revHead);
    }
}
