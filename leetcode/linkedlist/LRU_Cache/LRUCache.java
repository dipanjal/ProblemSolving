// Leetcode 146 | LRU Cache
// Difficulty: Medium
// Problem: https://leetcode.com/problems/lru-cache/description/
// Editorial: https://dipanjals-notebook.vercel.app/leetcode/linked-list/lru-cache/

import java.util.HashMap;

class LRUCache {
    // Doubly Linked List Node
    public static class Node {
        int key = -1;
        int val = -1;
        Node next = null;
        Node prev = null;
        public Node(int key, int val) {
            this.key = key;
            this.val = val; 
        }
    }

    // A doubly linked list
    public static class DoublyLinkedList {
        Node head = null; // head will be the LRU position
        Node tail = null; // tail will be the most recently used position
        
        public DoublyLinkedList() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void appendToTail(Node node) {
            Node prevNode = this.tail.prev;
            // linking node with tail
            node.next = this.tail;
            this.tail.prev = node;
            // linking node with prev node
            node.prev = prevNode;
            prevNode.next = node;
        }

        public void remove(Node node) {
            Node nextNode = node.next;
            Node prevNode = node.prev;
            // unlink the node from the linked list
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        public Node removeFromHead() {
            Node lruNode = this.head.next;
            if (lruNode == this.tail) {
                return null;
            }
            this.remove(lruNode);
            return lruNode;
        }
        
        public void printList() {
            Node current = this.head.next;
            while (current != this.tail) {
                System.out.print("(" + current.key + ", " + current.val + ") <-> ");
                current = current.next;
            }
            System.out.println("TAIL");
        }
    }

    int cap;
    HashMap<Integer, Node> cacheMap;
    DoublyLinkedList cacheList;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cacheMap = new HashMap<Integer, Node>();
        this.cacheList = new DoublyLinkedList();
    }

    private Node getNode(int key) {
        Node cachedNode = this.cacheMap.getOrDefault(key, null);
        if (cachedNode == null) {
            return null;
        }
        this.cacheList.remove(cachedNode);
        this.cacheList.appendToTail(cachedNode);
        return cachedNode;
    }
    
    public int get(int key) {
        Node cachedNode = this.getNode(key);
        if (cachedNode == null){
            return -1;
        }
        return cachedNode.val;
    }
    
    public void put(int key, int value) {
        Node cachedNode = this.getNode(key);
        if (cachedNode != null) {
            // update the value
            cachedNode.val = value;
        } else {
            this.writeInCache(key, value);   
        }
    }

    private void writeInCache(int key, int value) {
        // create a new node and add to the hashmap
        Node newNode = new Node(key, value);
        this.cacheMap.put(key, newNode);
        this.cacheList.appendToTail(newNode);
        // check cache capacity
        if (this.cacheMap.size() > this.cap) {
            this.evict();
        }
    }

    private void evict() {
        Node nodeRemoved = this.cacheList.removeFromHead();
        if (nodeRemoved != null && this.cacheMap.containsKey(nodeRemoved.key)) {
            this.cacheMap.remove(nodeRemoved.key);
        }
    }
    
    public void printCache() {
        this.cacheList.printList();
    }

    public static void main(String[] args) {
        // Test case
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.printCache();  // Should display the cache

        cache.put(2, 2);
        cache.printCache();  // Should display the cache

        System.out.println(cache.get(1));  // Should return 1
        cache.printCache();  // Should display the cache

        cache.put(3, 3);
        cache.printCache();  // Should display the cache

        System.out.println(cache.get(2));  // Should return -1 (not found)
        cache.printCache();  // Should display the cache

        cache.put(4, 4);
        cache.printCache();  // Should display the cache

        System.out.println(cache.get(1));  // Should return -1 (not found)
        cache.printCache();  // Should display the cache

        System.out.println(cache.get(3));  // Should return 3
        cache.printCache();  // Should display the cache

        System.out.println(cache.get(4));  // Should return 4
        cache.printCache();  // Should display the cache
    }
}
