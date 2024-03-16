package org.example.graph.DFS;

import org.example.utility.TreeNode;

import java.util.Stack;

class NodeAndDepth {
    TreeNode treeNode;
    int sum;

    public NodeAndDepth(TreeNode treeNode, int sum) {
        this.treeNode = treeNode;
        this.sum = sum;
    }
}

public class MaximumDepth {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

       // TreeNode treeNode = new TreeNode(1, null, new TreeNode(2));

        System.out.println(maxDepth(treeNode));
    }

//    public static int maxDepth(TreeNode root) {
//        Stack<NodeAndDepth> stack = new Stack<>();
//        stack.push(new NodeAndDepth(root,0));
//        int maxDepth = 0;
//        while (stack.size() != 0) {
//            NodeAndDepth nodeAndDepth = stack.pop();
//            TreeNode treeNode = nodeAndDepth.treeNode;
//            int depth = nodeAndDepth.sum +1;
//            maxDepth = Math.max(maxDepth, depth);
//            if (treeNode.left != null) {
//                stack.push(new NodeAndDepth(treeNode.left, depth));
//            }
//            if (treeNode.right != null) {
//                stack.push(new NodeAndDepth(treeNode.right, depth));
//            }
//        }
//        return maxDepth;
//    }

    public static int maxDepth(TreeNode root) {
        return solveMaxDepth(root, 0);
    }

    public static int solveMaxDepth(TreeNode root, int depth){
        if(root==null){
            return depth;
        }

        int left  = solveMaxDepth(root.left, depth+1);
        int right =  solveMaxDepth(root.right, depth+1);

        return Math.max(left, right);
    }
}
