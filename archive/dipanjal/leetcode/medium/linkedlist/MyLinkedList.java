package com.dipanjal.leetcode.medium.linkedlist;


/**
 * @author dipanjal
 * @since 0.0.1
 * problem: 707. Design Linked List
 * url: https://leetcode.com/problems/design-linked-list/
 */
public class MyLinkedList {

    Node head;
    Node tail;
    int size;

    public static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    public Node getNodeAtIndex(int index){
        if(index >= size || index < 0)
            return null;
        int count = 0;
        Node nodeAtIndex = this.head;
        while(count<index){
            nodeAtIndex = nodeAtIndex.next;
            count++;
        }
        return nodeAtIndex;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node nodeAtIndex = this.getNodeAtIndex(index);
        return nodeAtIndex == null ? -1 : nodeAtIndex.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(this.head != null)
            newNode.next = this.head;
        this.head = newNode;

        if(this.tail == null)
            this.tail = newNode;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(this.head == null)
            this.head = newNode;
        else
            this.tail.next = newNode;
        this.tail = newNode;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index>size) return;

        if(index == size){
            addAtTail(val);
        } else if(index == 0){
            addAtHead(val);
        } else{
            Node prevNode = this.getNodeAtIndex(index-1);
            Node newNode = new Node(val);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }

    }

    public void deleteFromHead(){
        if(this.head != null){
            this.head = this.head.next;
            size --;
        }
    }

    public void deleteFromTail(){
        Node previous = this.getNodeAtIndex(this.size - 2); //node before the tail
        previous.next = null; //unlink the tail
        tail = previous; //update the tail with the current last node
        size --;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        System.out.printf("Delete at index %d%n", index);
        if(index >= size)
            return;

        if(index == 0)
            deleteFromHead();
        else if(index == size-1)
            deleteFromTail();
        else{
            /*
            * prevNode->indexedNode->nextNode
            * prevNode->nextNode
            * */
            Node prevNode = this.getNodeAtIndex(index-1); //node before the desired indexed node
            prevNode.next = prevNode.next.next; //linking the previous with the next->next
            size --;
        }

    }

    public Node removeNthFromEnd(Node head, int n) {
        int nthNode = (this.size - n);
        Node prevNode = null;
        int count = 0;
        while(head != null) {
            if(count == nthNode - 1){
                prevNode = head;
            }
            if(count == nthNode){
                if(prevNode != null){
                    prevNode.next = head.next;
                    head.next = null;
                    return head;
                }
                System.out.printf("[%d] -> [%d]%n", count, head.val);
            }
            head = head.next;
            count++;
        }
        System.out.println("-------------------------");
        return head;
    }

    public void traverse(){
        Node node = this.head;
        int count = 0;
        while(node != null) {
            System.out.printf("[%d] -> [%d]%n", count++, node.val);
            node = node.next;
        }
        System.out.println("-------------------------");
    }


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        linkedList.addAtTail(4);
        linkedList.addAtTail(5);
        linkedList.removeNthFromEnd(linkedList.head, 2);
        linkedList.traverse();

//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
        /*testAddToHead(linkedList);
        testAddToTail(linkedList);
        testAddAtIndex(linkedList);
        testDeleteAtIndex(linkedList);
        System.out.println(linkedList.get(1));*/
    }

    private static void testAddToHead(MyLinkedList linkedList){
        linkedList.addAtHead(5);
        linkedList.addAtHead(7);
        linkedList.addAtHead(9);
    }

    private static void testAddToTail(MyLinkedList linkedList){
        linkedList.addAtTail(5);
        linkedList.addAtTail(7);
        linkedList.addAtTail(9);
    }

    private static void testAddAtIndex(MyLinkedList linkedList){
        linkedList.addAtIndex(0, 4);
        linkedList.addAtIndex(2, 6);
        linkedList.addAtIndex(linkedList.size, 10);
        linkedList.traverse();
    }

    private static void testDeleteAtIndex(MyLinkedList linkedList){
//        linkedList.deleteAtIndex(0);
        linkedList.deleteAtIndex(4);
        linkedList.deleteAtIndex(linkedList.size - 1);
//        linkedList.deleteAtIndex(linkedList.size - 2);
//        linkedList.addAtIndex(linkedList.size, 10);
        linkedList.traverse();
    }
}
