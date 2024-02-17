package org.example.graph.DFS;

import org.example.utility.TreeNode;

import java.util.Stack;

import static org.example.utility.Utility.createBinaryTree;

class NodeAndSum {
    TreeNode node;
    int sum;

    public NodeAndSum(TreeNode node, int sum) {
        this.node = node;
        this.sum = sum;
    }
}

public class hasPathOfTargetSum {

    public static void main(String[] args) {
        TreeNode treeNode = createBinaryTree(new Integer[]{1,2});
        System.out.println(hasPathSum(treeNode, 1));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        Stack<NodeAndSum> stack = new Stack<>();
        stack.push(new NodeAndSum(root, root.val));
        while (stack.size() != 0) {
            NodeAndSum nodeAndSum = stack.pop();
            TreeNode node = nodeAndSum.node;
            int sum = nodeAndSum.sum;
            if (sum == targetSum && node.left==null && node.right==null) {
                return true;
            }

            if (node.left != null) {
                stack.push(new NodeAndSum(node.left, node.left.val + sum));
            }
            if (node.right != null) {
                stack.push(new NodeAndSum(node.right, node.right.val + sum));
            }
        }
        return false;
    }
}