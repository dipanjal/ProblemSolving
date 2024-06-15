package com.dipanjal.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache2 {
    private final int capacity;
    private final Node headNode;
    private final Node tailNode;
    private final Map<Integer, Node> map;

    public LRUCache2(int capacity) {
        this.capacity = capacity;

        this.headNode = new Node(0,0);
        this.tailNode = new Node(0,0);
        headNode.next = tailNode;
        tailNode.prev = headNode;

        map = new HashMap<>();
    }

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node(key, value);
            map.put(node.key, node);
            insertAtHead(node);
        }
        if(map.size() > capacity)
            evict();
    }

    private void moveToHead(Node node) {
        removeFromTail(node);
        insertAtHead(node);
    }

    private void insertAtHead(Node node) {
        node.prev = headNode;
        node.next = headNode.next;

        headNode.next.prev = node;
        headNode.next = node;
    }

    private void evict() {
        map.remove(tailNode.prev.key);
        removeFromTail(tailNode.prev);
    }

    private void removeFromTail(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
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

        LRUCache2 lRUCache = new LRUCache2(3);
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
