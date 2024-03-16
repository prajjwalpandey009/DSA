package org.example.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        applyDFS(graph, currPath, list, 0);
        return list;
    }

    public static void applyDFS(int[][] graph, List<Integer> currPath, List<List<Integer>> res, int currNode) {
        if (currNode == graph.length - 1) {
            res.add(List.copyOf(currPath));
            return;
        }
        for (int neighbour : graph[currNode]) {
            currPath.add(neighbour);
            applyDFS(graph, currPath, res, neighbour);
            currPath.remove(currPath.size() - 1);
        }
    }

}
