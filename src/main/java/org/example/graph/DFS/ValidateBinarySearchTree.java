package org.example.graph.DFS;

import org.example.utility.TreeNode;
import org.example.utility.Utility;

import java.util.Stack;

class Pair {
    TreeNode node;
    int[] range = new int[2];

    public Pair(TreeNode node, int[] range) {
        this.node = node;
        this.range = range;
    }
}

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(isValidBST(Utility.createBinaryTree(new Integer[]{2, 2, 2})));
    }

    public static boolean isValidBST(TreeNode root) {
        return solveIsvalidTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean solveIsvalidTree(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val > minValue && root.val < maxValue) {

        } else {
            return false;
        }

        boolean left = solveIsvalidTree(root.left, minValue, root.val);
        boolean right = solveIsvalidTree(root.right, root.val, maxValue);
        return left && right;
    }
}
