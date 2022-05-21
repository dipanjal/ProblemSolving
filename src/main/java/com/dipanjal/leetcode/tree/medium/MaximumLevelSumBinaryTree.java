package com.dipanjal.leetcode.tree.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class MaximumLevelSumBinaryTree {

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
        int level;
        TreeNode node;
        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public static int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0;
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        Deque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(1, root));
        while(!queue.isEmpty()) {
            int length = queue.size();
            int currSum = 0 , currLevel = 0;

            for(int i=0; i<length; i++) {
                Pair tempPair = queue.poll();
                if(tempPair != null) {
                    TreeNode temp = tempPair.node;
                    currSum += temp.val;
                    currLevel = tempPair.level;
                    if(temp.left != null)
                        queue.add(new Pair(currLevel + 1, temp.left));
                    if(temp.right != null)
                        queue.add(new Pair(currLevel + 1, temp.right));
                }
            }
            if(maxSum < currSum) {
                maxSum = currSum;
                maxLevel = currLevel;
            }
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(
                1,
                new TreeNode(7, new TreeNode(7), new TreeNode(-8)),
                new TreeNode(0)
        );
        System.out.println(maxLevelSum(tree));
    }
}
