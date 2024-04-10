package org.example.graph.dijhesktra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {

    public static void main(String[] args) {
        System.out.println(maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<double[]>> list = new ArrayList<>();
        double[] distance = new double[n];

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            distance[i] = Double.MIN_VALUE;
        }

        int start = 0;

        for (int[] node : edges) {
            list.get(node[0]).add(new double[]{node[1], succProb[start]});
            list.get(node[1]).add(new double[]{node[0], succProb[start]});
            start++;
        }

        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((n2,n1)-> (int) (n2[1]-n1[1]));
        priorityQueue.add(new double[]{start_node, 1});

        while (!priorityQueue.isEmpty()) {
            double[] node = priorityQueue.poll();
            for (double[] doubles : list.get((int) node[0])) {
                int destiNode = (int) doubles[0];
                double newDistance = doubles[1] * node[1];
                if (distance[destiNode] < newDistance) {
                    distance[destiNode] = newDistance;
                    priorityQueue.add(new double[]{destiNode, newDistance});
                }
            }
        }

        return distance[end_node];
    }
}
