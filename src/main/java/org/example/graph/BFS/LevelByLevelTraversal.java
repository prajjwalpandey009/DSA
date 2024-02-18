package org.example.graph.BFS;

import org.example.utility.TreeNode;
import org.example.utility.Utility;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class NodesAndList {
    TreeNode node;
    Integer level;

    public NodesAndList(TreeNode node, Integer level) {
        this.node = node;
        this.level = level;
    }
}

public class LevelByLevelTraversal {
    public static void main(String[] args) {
        levelOrder(Utility.createBinaryTree(new Integer[]{1, 2, 3, 4, null, null, 5}));
    }

    public static List<List<Integer>> levelOrder(org.example.utility.TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<NodesAndList> queue = new ArrayDeque<>();
        queue.add(new NodesAndList(root, 0));


        while (queue.size() != 0) {
            NodesAndList node = queue.poll();
            TreeNode treeNode = node.node;
            Integer level = node.level;

            if (lists.size() == level + 1) {
                List<Integer> list = lists.get(level);
                list.add(treeNode.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(treeNode.val);
                lists.add(list);
            }

            if (treeNode.left != null) {
                queue.add(new NodesAndList(treeNode.left, level + 1));
            }

            if (treeNode.right != null) {
                queue.add(new NodesAndList(treeNode.right, level + 1));
            }

        }
        return lists;
    }
}
