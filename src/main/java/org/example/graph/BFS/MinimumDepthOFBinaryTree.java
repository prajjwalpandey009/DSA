package org.example.graph.BFS;


import java.util.ArrayDeque;
import java.util.Queue;

class NodeAndDepth {
    TreeNode treeNode;
    int sum;

    public NodeAndDepth(TreeNode treeNode, int sum) {
        this.treeNode = treeNode;
        this.sum = sum;
    }
}

public class MinimumDepthOFBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(minDepth(treeNode));
    }

    public static int minDepth(TreeNode root) {
        Queue<NodeAndDepth> queue = new ArrayDeque<>();
        queue.add(new NodeAndDepth(root, 0));
        int minDepth = 0;
        while (queue.size() != 0) {
            NodeAndDepth nodeAndDepth = queue.poll();
            TreeNode node = nodeAndDepth.treeNode;
            int depth = nodeAndDepth.sum + 1;
            minDepth = Math.max(depth, minDepth);
            if (node.left == null && node.right == null) {
                return minDepth;
            }
            if (node.left != null) {
                queue.add(new NodeAndDepth(node.left, depth));
            }
            if (node.right != null) {
                queue.add(new NodeAndDepth(node.right, depth));
            }
        }
        return minDepth;
    }
}
