package org.example.graph.DFS;

import org.example.utility.TreeNode;

public class IsSameTree {
    public static void main(String[] args) {
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //Base case
        if (p == null && q == null) {
            //here both the nodes are null .so we have successfully verified
            return true;
        } else if (p == null || q == null) {
            //here one of the node is null .so we cannot verified so return false.
            return false;
        } else if (p.val != q.val) {
            //here value is not equal so return false
            return false;
        }
        //continuously do recursive call
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
