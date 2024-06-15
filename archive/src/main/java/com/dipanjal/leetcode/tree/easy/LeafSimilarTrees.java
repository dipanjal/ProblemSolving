package com.dipanjal.leetcode.tree.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 * difficulty: easy
 * section: tree
 */
public class LeafSimilarTrees {
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

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        List<Integer> seq1 = getLeafSequence(root1);
        List<Integer> seq2 = getLeafSequence(root2);

        if (seq1.size() != seq2.size())
            return false;

        for (int i=0; i<seq1.size(); i++) {
            if (seq1.get(i) != seq2.get(i))
                return false;
        }
        return true;

    }

    /**
     *
     * DFS using stack
     */
    private static List<Integer> getLeafSequence(TreeNode root) {
        List<Integer> seqList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null)
                seqList.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return seqList;
    }

    private static void test1() {
        TreeNode node1 = new TreeNode(
                3,
                new TreeNode(
                        5,
                        new TreeNode(6),
                        new TreeNode(2, new TreeNode(7), new TreeNode(4))
                ),
                new TreeNode(
                        1,
                        new TreeNode(9),
                        new TreeNode(8)
                )
        );

        TreeNode node2 = new TreeNode(
                2,
                new TreeNode(5, new TreeNode(6), new TreeNode(7)),
                new TreeNode(1, new TreeNode(4),
                        new TreeNode(2, new TreeNode(9), new TreeNode(8)))
        );

        System.out.println(leafSimilar(node1, node2));

    }

    public static void main(String[] args) {
        test1();
    }
}
