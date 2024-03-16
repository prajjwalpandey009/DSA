package org.example.graph.DFS;

import org.example.utility.TreeNode;

public class isSymmetric {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return checkIfSymmetric(root.left, root.right);
    }

    public static boolean checkIfSymmetric(TreeNode left, TreeNode right) {
        //base
        if (left == null && right == null) {
            //we have reached to end so have verified so return true
            return true;
        } else if (left == null || right == null) {
            //If any of the node is null and other node is not null return false
            return false;
        } else if (left.val != right.val) {
            //If the val of the both node is not equal.
            return false;
        }
        return checkIfSymmetric(left.right, right.left) &&
                checkIfSymmetric(left.left, right.right);
    }
}
