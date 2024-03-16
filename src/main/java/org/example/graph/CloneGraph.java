package org.example.graph;

import java.util.*;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node createGraph(int[][] input) {
        Map<Integer, Node> map = new HashMap<>();

        // Create all nodes
        for (int i = 0; i < input.length; i++) {
            map.put(i + 1, new Node(i + 1));
        }

        // Connect neighbors
        for (int i = 0; i < input.length; i++) {
            int[] neighbors = input[i];
            Node currentNode = map.get(i + 1);
            for (int neighborVal : neighbors) {
                Node neighborNode = map.get(neighborVal);
                currentNode.neighbors.add(neighborNode);
            }
        }

        return map.get(1); // Return the first node
    }

    public static void main(String[] args) {
        cloneGraph(createGraph(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}}));
    }

    public static Node cloneGraph(Node node) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        Node[] map = new Node[101];
        boolean[] visited = new boolean[101];
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            if (visited[head.val]) {
                continue;
            }
            visited[head.val] = true;
            if (map[head.val] == null) {
                map[head.val] = new Node(head.val, new ArrayList<>());
            }
            head.neighbors.forEach(
                    n -> {
                        if (map[n.val] == null) {
                            map[n.val] = new Node(n.val, new ArrayList<>());
                            map[head.val].neighbors.add(map[n.val]);
                        } else {
                            map[head.val].neighbors.add(map[n.val]);
                        }
                        queue.add(n);
                    }
            );
        }
        return map[node.val];
    }

}
