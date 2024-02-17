package org.example.graph.DFS;

import org.example.utility.TreeNode;
import org.example.utility.Utility;

import java.util.Stack;

class NodeSumMarker {
    TreeNode node;
    String direction;

    public NodeSumMarker(TreeNode node, String direction) {
        this.node = node;
        this.direction = direction;
    }
}

public class SumofLeftLeaves {

    public static void main(String[] args) {

        TreeNode treeNode = Utility.createBinaryTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(sumOfLeftLeaves(treeNode));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<NodeSumMarker> stack = new Stack<>();
        stack.push(new NodeSumMarker(root, "h"));
        int sum = 0;
        while (stack.size() != 0) {
            NodeSumMarker nodeSumMarker = stack.pop();
            TreeNode node = nodeSumMarker.node;
            if (nodeSumMarker.direction.equals("l") && node.left == null && node.right == null) {
                sum = sum + node.val;
            }
            if (node.left != null) {
                stack.push(new NodeSumMarker(node.left, "l"));
            }
            if (node.right != null) {
                stack.push(new NodeSumMarker(node.right, "r"));
            }
        }
        return sum;
    }
}
