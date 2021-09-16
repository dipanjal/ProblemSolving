package com.dipanjal.leetcode.medium.linkedlist;


/**
 * @author dipanjal
 * @since 0.0.1
 * problem: 707. Design Linked List
 * url: https://leetcode.com/problems/design-linked-list/
 */
public class MyDoublyLinkedList {

    Node head;
    Node tail;
    int size;

    public static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyDoublyLinkedList() {

    }


    public boolean isHead(Node node){
        return node.prev == null;
    }
    public boolean isTail(Node node){
        return node.next == null;
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
        addAtHead(new Node(val));
    }

    public void addAtHead(Node newHead){
        if(this.head != null) {
            newHead.next = head;
            head.prev = newHead;
        }
        head = newHead;

        if(this.tail == null)
            this.tail = newHead;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.head == null)
            this.addAtHead(val);
//            this.head = newNode;
        else{
            Node newNode = new Node(val);
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
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
            Node nextNode = prevNode.next;
            Node newNode = new Node(val);

            prevNode.next = nextNode;
            newNode.prev = prevNode;

            nextNode.prev = newNode;
            newNode.next = nextNode;

//            newNode.prev = prevNode;
//            newNode.next = prevNode.next;
//            prevNode.next = newNode;
            size++;
        }
    }

    public void deleteFromHead(){
        if(this.head != null){
            Node nextHead = head.next;
            nextHead.prev = null;
            head= nextHead;
            size --;
        }
    }

    public void deleteFromTail(){
        Node beforeTail = tail.prev;
        beforeTail.next = null; //unlink the tail
        tail = beforeTail; //update the tail with the current last node
        size --;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        System.out.printf("Delete at index %d%n", index);
        if(index >= size) return;
        if(index == 0)
            deleteFromHead();
        else if(index == size-1)
            deleteFromTail();
        else{
            Node node = this.getNodeAtIndex(index);
            Node prevNode = node.prev;
            if(!isTail(node)){
                Node nextNode = node.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }
            prevNode.next = null;
            size --;
        }

    }

    public void deleteNode(Node node){
        if(node == null) return;

        if(isHead(node))
            deleteFromHead();
        else if(isTail(node))
            deleteFromTail();
        else {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }

    public void moveToHead(Node node){
        if(node == null) return;
        if(isHead(node)) return;
        deleteNode(node);
        addAtHead(node);
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
        Node headPointer = this.head;
        int count = 0;
        while(headPointer != null) {
            System.out.printf("[I: %d] -> [V: %d]%n", count++, headPointer.val);
            headPointer = headPointer.next;
        }
        System.out.println("-------------------------");
    }

    public void traverseBack(){
        Node tailPointer = this.tail;
        int count = size-1;
        while(tailPointer != null) {
            System.out.printf("[I: %d] -> [V: %d]%n", count--, tailPointer.val);
            tailPointer = tailPointer.prev;
        }
        System.out.println("-------------------------");
    }


    public static void main(String[] args) {
        MyDoublyLinkedList linkedList = new MyDoublyLinkedList();
        linkedList.addAtTail(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        linkedList.addAtTail(4);
        linkedList.addAtTail(5);
        linkedList.traverse();

        System.out.println("----------------------");

        Node node = linkedList.getNodeAtIndex(4);
        linkedList.moveToHead(node);
        linkedList.traverse();

        /*System.out.println("--------------Removing from Index 2-------------");
        linkedList.deleteAtIndex(2);
        linkedList.traverse();

        System.out.println("--------------Reverse Traverse-------------");
        linkedList.traverseBack();*/

//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
        /*testAddToHead(linkedList);
        testAddToTail(linkedList);
        testAddAtIndex(linkedList);
        testDeleteAtIndex(linkedList);
        System.out.println(linkedList.get(1));*/
    }

    private static void testAddToHead(MyDoublyLinkedList linkedList){
        linkedList.addAtHead(5);
        linkedList.addAtHead(7);
        linkedList.addAtHead(9);
    }

    private static void testAddToTail(MyDoublyLinkedList linkedList){
        linkedList.addAtTail(5);
        linkedList.addAtTail(7);
        linkedList.addAtTail(9);
    }

    private static void testAddAtIndex(MyDoublyLinkedList linkedList){
        linkedList.addAtIndex(0, 4);
        linkedList.addAtIndex(2, 6);
        linkedList.addAtIndex(linkedList.size, 10);
        linkedList.traverse();
    }

    private static void testDeleteAtIndex(MyDoublyLinkedList linkedList){
//        linkedList.deleteAtIndex(0);
        linkedList.deleteAtIndex(4);
        linkedList.deleteAtIndex(linkedList.size - 1);
//        linkedList.deleteAtIndex(linkedList.size - 2);
//        linkedList.addAtIndex(linkedList.size, 10);
        linkedList.traverse();
    }
}
