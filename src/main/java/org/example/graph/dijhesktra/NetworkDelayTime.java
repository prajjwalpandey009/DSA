package org.example.graph.dijhesktra;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1));
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> listoflist = new ArrayList<>();
        listoflist.add(new ArrayList<>());

        int[] distance = new int[n + 1];
        distance[0] = 0;
        distance[1] = 0;

        for (int i = 1; i < n + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
            listoflist.add(new ArrayList<>());
        }

        for (int[] nodes : times) {
            listoflist.get(nodes[0]).add(new int[]{nodes[1], nodes[2]});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2[1]));
        pq.add(new int[]{k, 0});
        distance[k] = 0;

        while (!pq.isEmpty()) {
            int[] nodesAndCost = pq.poll();
            int node = nodesAndCost[0];
            int cost = nodesAndCost[1];

            for (int[] adjacentNodeAndCost : listoflist.get(node)) {
                int adjacentNode = adjacentNodeAndCost[0];
                int newcostToAdjacentNode = cost + adjacentNodeAndCost[1];

                int oldCostToAdjacentNode = distance[adjacentNode];


                //checking of cost to adjacent node is low then update it in distance array
                if (oldCostToAdjacentNode > newcostToAdjacentNode) {
                    distance[adjacentNode] = newcostToAdjacentNode;
                    pq.add(new int[]{adjacentNode, newcostToAdjacentNode});
                }
            }
        }

        int end = distance.length - 1;
        int max = 0;
        while (end >= 0) {
            if (distance[end] == Integer.MAX_VALUE) {
             return -1;
            }
            max = Math.max(max, distance[end]);
            end--;
        }
        return max;
    }
}
