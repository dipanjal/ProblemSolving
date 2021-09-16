package com.dipanjal.common.caching;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author dipanjal
 * @since 0.0.1
 */

public class LRUCache<K, V> {

    private final int capacity;
    private final Node<K, V> headNode;
    private final Node<K,V> tailNode;
    private final Map<K, Node<K,V>> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.headNode = new Node<>(null, null);
        this.tailNode = new Node<>(null, null);
        headNode.next = tailNode;
        tailNode.prev = headNode;

        map = new HashMap<>();
    }

    private static class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;
        Node<K,V> prev;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public V get(K key) {
        if(!map.containsKey(key))
            return null;

        Node<K,V> node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public Optional<V> getOpt(K key){
        return Optional.ofNullable(get(key));
    }

    public void put(K key, V value) {
        Node<K,V> node;
        if(map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node<>(key, value);
            map.put(node.key, node);
            insertAtHead(node);
        }
        if(map.size() > capacity)
            evict();
    }

    private void moveToHead(Node<K,V> node) {
        removeFromTail(node);
        insertAtHead(node);
    }

    private void insertAtHead(Node<K,V> node) {
        node.prev = headNode;
        node.next = headNode.next;

        headNode.next.prev = node;
        headNode.next = node;
    }

    private void evict() {
        map.remove(tailNode.prev.key);
        removeFromTail(tailNode.prev);
    }

    private void removeFromTail(Node<K,V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void getAndPrint(K key){
        var value = get(key);
        if(value == null)
            System.out.println("Record not Found");
        else
            System.out.println(value);


//        System.out.println(get(key));
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lRUCache = new LRUCache<>(3);
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
    }
}
