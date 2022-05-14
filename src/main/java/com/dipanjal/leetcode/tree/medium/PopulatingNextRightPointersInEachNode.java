package com.dipanjal.leetcode.tree.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Leetcode 116
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * difficulty: medium
 * section: tree
 */
public class PopulatingNextRightPointersInEachNode {

    public static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Algorithm: BFS
     * TC: O(n)
     * SC: O(n)
     */
    public Node connectBFSApproach(Node root) {
        if(root == null)
            return null;

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Node> nodes = new ArrayList<>();
            Node currRoot = queue.peek();

            int length = queue.size();
            for(int i=0; i<length; i++) {
                Node temp = queue.poll();
                if(temp != null) {
                    if(temp.left != null) {
                        nodes.add(temp.left);
                        queue.add(temp.left);
                    }
                    if(temp.right != null) {
                        nodes.add(temp.right);
                        queue.add(temp.right);
                    }
                }
            }
            Node left = currRoot.left;
            for(Node node : nodes) {
                left.next = node;
                left = left.next;
            }
        }
        return root;
    }

    /**
     * Algorithm: Two Pointer Approach, using Leftmost and Head pointer
     * TC: O(n)
     * SC: O(1)
     */
    public static Node connectNextPointerApproach(Node root) {
        if(root == null)
            return null;

        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node leftmost = root;

        // Once we reach the final level, we are done
        while(leftmost != null) {
            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the
            // corresponding links for the next level
            Node head = leftmost;

            while(head != null) {
                //connection between nodes under the same parent
                if(head.left != null)
                    head.left.next = head.right;

                //connection between nodes under different parent
                if(head.next != null && head.right != null)
                    head.right.next = head.next.left;

                // Progress along the list (nodes on the current level)
                head = head.next;
            }
            // Move onto the next level
            leftmost = leftmost.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2, new Node(4), new Node(5)),
                new Node(3, new Node(6), new Node(7))
                );
        connectNextPointerApproach(node);
    }
}
