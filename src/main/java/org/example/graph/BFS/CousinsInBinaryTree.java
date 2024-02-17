package org.example.graph.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

//Height of node is the number of edges present between node that node to the deepest node
//Depth of node is the number of edge present from root node to that node

//https://leetcode.com/problems/keys-and-rooms/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        //  TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5)));

        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        System.out.println(isCousins(root, 2, 3));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {

        Queue<Object[]> queue = new ArrayDeque<>();

        Object[] depthX = new Object[3];
        Object[] depthY = new Object[3];
        if (root.left != null) {
            queue.add(new Object[]{root, root.left, 0});
        }
        if (root.right != null) {
            queue.add(new Object[]{root, root.right, 0});
        }

        while (queue.size() != 0) {
            Object[] prev = queue.poll();
            TreeNode rootTree = (TreeNode) prev[0];
            TreeNode treeNode = (TreeNode) prev[1];
            if (treeNode.val == x) {
                depthX[0] = treeNode;
                depthX[1] = (int) prev[2] + 1;
                depthX[2] = rootTree;
            }
            if (treeNode.val == y) {
                depthY[0] = treeNode;
                depthY[1] = (int) prev[2] + 1;
                depthY[2] = rootTree;
            }
            if (treeNode.left != null) {
                queue.add(new Object[]{treeNode, treeNode.left, (int) prev[2] + 1});
            }
            if (treeNode.right != null) {
                queue.add(new Object[]{treeNode, treeNode.right, (int) prev[2] + 1});
            }
        }
        if (depthY[0] != depthX[0] && depthX[1] == depthY[1] && depthX[2] != depthY[2]) {
            return true;
        }
        return false;
    }
}
