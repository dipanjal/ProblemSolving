package com.dipanjal.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    private Map<Integer, Node> map;

    public static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    /* Linked List Operations */
    public boolean isHead(Node node) {
        return node.prev == null;
    }
    public boolean isTail(Node node) {
        return node.next == null;
    }

    private void deleteFromHead() {
        if(head != null) {
            Node nextHead = head.next;
            nextHead.prev = null;
            head= nextHead;
            size--;
        }
    }
    private void deleteFromTail() {
        Node beforeTail = tail.prev;
        if(beforeTail!=null){
            beforeTail.next = null; //unlink the tail
        }
        tail = beforeTail; //update the tail with the current last node
        size--;
    }
    private void deleteNode(Node node) {
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
            size --;
        }
    }
    public void addAtHead(Node newHead) {
        if(this.head != null) {
            newHead.next = head;
            head.prev = newHead;
        }
        head = newHead;
        head.prev = null;

        if(this.tail == null)
            this.tail = newHead;
        size++;
    }

    private void moveToHead(Node node) {
        if(node == null) return;
        if(isHead(node)) return;
        deleteNode(node);
        addAtHead(node);
    }


    /* LRU Operations */
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node cachedNode = map.get(key);
        this.moveToHead(cachedNode);
        return cachedNode.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node cachedNode = map.get(key);
            cachedNode.val = value;
            this.moveToHead(cachedNode);
        }else{
            addNewItemIntoCache(key, value);
        }
    }

    private void addNewItemIntoCache(int key, int value){
        if(capacity == size)
            removeLastFromCache();

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        this.addAtHead(newNode);
    }

    private void removeLastFromCache(){
        map.remove(tail.key);
        deleteFromTail();
    }

    private void getAndPrint(int key){
        System.out.println(get(key));
    }

    public static void main(String[] args) {
/*        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4*/

        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1,1); //size:1
        lRUCache.put(2,2); //size:2
        lRUCache.put(3,3); //size:3
        lRUCache.put(4,4); //1 will be kicked out size:3

        lRUCache.getAndPrint(4); //4 and head=4 size:3
        lRUCache.getAndPrint(3); //3 and head=3 size:3
        lRUCache.getAndPrint(2); //2 and head=2
        lRUCache.getAndPrint(1); // -1 and head=2

        lRUCache.put(5,5); //head = 5 | 5 -> 2 -> 3 | 4 should be kicked out here
        lRUCache.getAndPrint(1);
        lRUCache.getAndPrint(2); //2 is head now
        lRUCache.getAndPrint(3); //
        lRUCache.getAndPrint(4);
        lRUCache.getAndPrint(5);


//        ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
//        [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
    }
}
