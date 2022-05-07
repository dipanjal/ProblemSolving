package com.dipanjal.leetcode.tree.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * difficulty: easy
 * section: tree
 */

public class MinimumDepthBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode right) {
            this.val = val;
            this.right = right;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        else if(root.left != null && root.right != null)
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else if(root.left != null)
            return minDepth(root.left) + 1;
        else
            return minDepth(root.right) + 1;
    }

    /** Solution 2: Using Stack */
    public static class Pair {
        public TreeNode node;
        public int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public static int minDepthUsingStack(TreeNode root) {
        if(root == null)
            return 0;

        Deque<Pair> queue = new ArrayDeque<>();
        queue.push(new Pair(root, 1));
        int minDepth = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Pair pair = queue.pop();
            TreeNode node = pair.node;
            int currDepth = pair.depth;
            if(node.left == null && node.right == null) {
                if(minDepth > currDepth)
                    minDepth  = currDepth;
            }
            if(node.right != null)
                queue.push(new Pair(node.right, currDepth+1));
            if(node.left != null)
                queue.push(new Pair(node.left, currDepth+1));
        }
        return minDepth;
    }

    private static void test1() {
        TreeNode tree = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7))
        );
        System.out.println(minDepthUsingStack(tree));
    }

    private static void test2() {
        TreeNode tree = new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), new TreeNode(6))));
        System.out.println(minDepthUsingStack(tree));
    }

    public static void main(String[] args) {
        test1();
    }
}
