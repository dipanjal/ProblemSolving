package com.dipanjal.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * easy
 * tree
 */
public class InOrder {

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

    private static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    public static void traverse(TreeNode root, List<Integer> res) {
        if (root != null) {
            traverse(root.left, res);
            res.add(root.val);
            traverse(root.right, res);
        }
    }

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3)
        );
        System.out.println(inorderTraversalRecursive(tree));
    }

}
