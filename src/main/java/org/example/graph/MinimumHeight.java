package org.example.graph;

import java.util.*;

public class MinimumHeight {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0},
                {1, 2},
                {1, 3}
        };

        findMinHeightTrees(4, grid);
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        adjList.keySet().forEach(
                k -> queue.add(k)
        );


        return List.of(1);
    }
}
