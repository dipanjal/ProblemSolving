package com.dipanjal.leetcode.tree.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * difficulty: medium
 * section: tree
 */
public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        /* taking a queue for BFS */
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int length = queue.size();
            /* we will be polling all nodes of a level */
            for (int i=0; i<length; i++) {
                TreeNode temp = queue.poll();
                if(temp != null) {
                    subList.add(temp.val);
                    /* if the node has left child, enqueue it */
                    if(temp.left != null)
                        queue.add(temp.left);
                    /* if the node has right child, enqueue it */
                    if(temp.right != null)
                        queue.add(temp.right);
                }
            }
            result.add(subList);
        }
        return result;
    }

    private static void test1() {
        TreeNode tree = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7))
        );
        System.out.println(levelOrder(tree).toString());
    }

    public static void main(String[] args) {
        test1();
    }
}
