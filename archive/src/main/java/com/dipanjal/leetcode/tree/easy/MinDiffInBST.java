package com.dipanjal.leetcode.tree.easy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * easy
 * tree
 */
public class MinDiffInBST {

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

    public static int minDiffInBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dfs(root, values);
        Collections.sort(values);

        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i<values.size() - 1; i++) {
            int currentDiff = values.get(i+1) - values.get(i);
            minDiff = Math.min(minDiff, currentDiff);
        }
        return minDiff;
    }

    public static void dfs(TreeNode root, List<Integer> values) {
        if(root == null)
            return;
        dfs(root.left, values);
        dfs(root.right, values);
        values.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(6)
        );
        minDiffInBST(treeNode);
    }
}
