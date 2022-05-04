package com.dipanjal.leetcode.easy.tree;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/path-sum/
 * difficulty: easy
 * section: tree
 */
public class PathSum {

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

    public static class Pair {
        public TreeNode node;
        public int pathSum;

        public Pair(TreeNode node, int pathSum) {
            this.node = node;
            this.pathSum = pathSum;
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, root.val));

        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode tempNode = pair.node;
            int tempSum = pair.pathSum;

            /* IF Leaf Node*/
            if(tempNode.left == null && tempNode.right == null && tempSum == targetSum) {
                return true;
            }
            /*
             * if tempNode has left child
             * make a new pair with the left node and add the totalCost = (tempSum + leftChild.val)
             * push the pair to the stack
             * */
            if(tempNode.left != null)
                stack.push(new Pair(tempNode.left, tempSum+tempNode.left.val));
            /*
             * if tempNode has right child
             * make a new pair with the right node and add the totalCost = (tempSum + rightChild.val)
             * push the pair to the stack
             * */
            if(tempNode.right != null)
                stack.push(new Pair(tempNode.right, tempSum+tempNode.right.val));
        }
        return false;
    }

}
