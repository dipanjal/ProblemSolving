package com.dipanjal.common;

import java.util.List;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public class LinkList<T> {

    public Node<T> head; // head of list
    Node<T> tail; // head of list
    int size;

    public static class Node<T> {
        public T data;
        public Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkList(){}

    public void insert(T data){
        // Create a new node with given data
        Node<T> newNode = new Node<>(data);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node<T> previous = this.tail;
            previous.next = newNode;
        }
        this.tail = newNode;
        size++;
    }

    public void insert(List<T> nums) {
        for(T data : nums)
            this.insert(data);
    }

    public void insert(T[] nums) {
        for(T data : nums)
            this.insert(data);
    }

    public void traverse(){
        Node<T> node = this.head;
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public Node<T> search(T data) {
        Node<T> node = this.head;
        while(node != null) {
            if(node.data.equals(data))
                return node;
            node = node.next;
        }
        return null;
    }

    public void pop() {
        Node<T> node = this.head;
        while(node != null) {
            if(node.next == this.tail){
                node.next = null;
                this.tail = node;
                this.size--;
                break;
            }
            node = node.next;
        }
    }



    public static void main(String[] args) {
        Integer[] nums = {5,6,7,8,9};
        LinkList<Integer> list = new LinkList<>();

        list.insert(nums);
        list.traverse();
        System.out.println("Size: "+list.size);
        Node<Integer> node = list.search(7);
        System.out.println("Search Result: "+ node.data);

        list.pop();
        list.traverse();
        System.out.println("Size: "+list.size);
    }
}

