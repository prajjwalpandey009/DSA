package org.example.graph.dijhesktra;

import java.util.*;

public class CheapestFlightWithKStop {
    public static void main(String[] args) {
        System.out.println(findCheapestPrice(5, new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}
                , {1, 4, 1}, {4, 2, 1}}, 0, 2, 2));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Creating adjacency list representation of the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int s = flight[0];
            int e = flight[1];
            int c = flight[2];
            graph.get(s).add(new int[]{e, c});
        }

        // Priority queue for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Cost array to track minimum cost to reach each node with given number of stops
        int[][] costs = new int[n][k + 2]; // k + 2 because we need to track up to k stops + source node (0 stops)
        for (int i = 0; i < n; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }

        // Adding source node to the priority queue
        pq.offer(new int[]{0, src, 0}); // {cost, node, stops}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];
            int stops = curr[2];

            // If destination is reached, return the cost
            if (node == dst) {
                return cost;
            }

            // If the number of stops exceeds k, continue to the next iteration
            if (stops > k) {
                continue;
            }

            // Explore neighbors of the current node
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int nextCost = neighbor[1];

                // Calculate total cost to reach next node
                int totalCost = cost + nextCost;

                // If the total cost is less than the cost recorded for the next node with the current number of stops
                // update the cost and add the next node to the priority queue
                if (totalCost < costs[nextNode][stops + 1]) {
                    costs[nextNode][stops + 1] = totalCost;
                    pq.offer(new int[]{totalCost, nextNode, stops + 1});
                }
            }
        }

        // If destination cannot be reached within k stops, return -1
        return -1;
    }
}
