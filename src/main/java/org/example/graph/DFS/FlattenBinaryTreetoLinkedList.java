package org.example.graph.DFS;

import org.example.utility.TreeNode;
import org.example.utility.Utility;

public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        flatten(Utility.createBinaryTree(new Integer[]{1, 2, 5, 3, 4, null, 6}));
    }

    public static void flatten(TreeNode root) {
          doFlatten(root);
        System.out.println("Hi");
    }

    public static TreeNode doFlatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftTail = doFlatten(root.left);
        TreeNode rightTail = doFlatten(root.right);

        if (root.left != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightTail != null) {
            return rightTail;
        } else if (leftTail != null) {
            return leftTail;
        }
        return root;
    }




//    public static void flatten(TreeNode root) {
//        LinkedList<Integer> list = new LinkedList<>();
//        applyDFSOnTree(root, list);
//        TreeNode curr = root;
//        for (int i = 0; i < list.size(); i++) {
//            curr.val = list.get(i);
//            if (curr.right == null && (i < list.size()-1)) {curr.right = new TreeNode(0);
//            }
//            curr = curr.right;
//        }
//        System.out.println(list);
//    }
//
//    private static void applyDFSOnTree(TreeNode root, LinkedList<Integer> list) {
//
//        list.add(root.val);
//        if (root.left == null && root.right == null) {
//            return;
//        }
//        if (root.left != null) {
//            applyDFSOnTree(root.left, list);
//            root.left = null;
//        }
//
//        if (root.right != null) {
//            applyDFSOnTree(root.right, list);
//        }
//    }
}
