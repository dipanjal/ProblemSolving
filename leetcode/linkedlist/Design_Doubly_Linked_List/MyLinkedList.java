// Leetcode: 707 | Design Doubly Linked List
// Difficulty: Medium
// Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/design-a-doubly-linked-list/

class MyLinkedList {
    private static class Node {
        int val; 
        Node prev, next;
        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    int size; 
    Node head, tail;
    public MyLinkedList() {
        this.size = 0;
        // Dummy initialization
        this.head = new Node(-1, null, null);
        this.tail = new Node(-1, null, null);
        // Linking dummy head and tail together
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private Node getNthNode(Node ptr, int index) {
        while (ptr != null && index > 0) {
            ptr = ptr.next;
            index--;
        }
        return ptr;
    }
    
    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }
        Node firstNode = this.head.next;
        Node nthNode = this.getNthNode(firstNode, index);
        return nthNode != null ? nthNode.val : -1;
    }

    private void insert(int val, Node prev, Node next) {
        Node node = new Node(val, prev, next);
        prev.next = node;
        next.prev = node;
        this.size++;  // increment size by one
    }
    
    public void addAtHead(int val) {
        this.insert(val, this.head, this.head.next);
    }
    
    public void addAtTail(int val) {
        this.insert(val, this.tail.prev, this.tail);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > this.size)
            return;
        if (index == 0)
            this.addAtHead(val);
        else if (index == this.size)
            this.addAtTail(val);
        else {
            Node beforeNthNode = this.getNthNode(this.head, index);
            this.insert(val, beforeNthNode, beforeNthNode.next);
        }
    }

    private void delete(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;  // decrement size by one
    }
    
    public void deleteAtIndex(int index) {
        if (index > this.size - 1)
            return;
        Node firstNode = this.head.next;
        Node nthNode = this.getNthNode(firstNode, index);
        this.delete(nthNode);
    }
    
    public void printList() {
        Node curr = this.head.next;
        while (curr != this.tail) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("None");
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.printList();
        obj.deleteAtIndex(1);
        obj.printList();
        obj.addAtHead(2);
        obj.printList();
        obj.addAtHead(7);
        obj.printList();
        obj.addAtHead(3);
        obj.printList();
        obj.addAtHead(2);
        obj.printList();
        obj.addAtHead(5);
        obj.printList();
        obj.addAtTail(5);
        obj.printList();
        int val = obj.get(5);
        System.out.println(val); // Expected Output: 2
        obj.deleteAtIndex(6);
        obj.deleteAtIndex(4);
    }
}
