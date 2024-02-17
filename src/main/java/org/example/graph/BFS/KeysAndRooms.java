package org.example.graph.BFS;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/keys-and-rooms/submissions/1173258803/
public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(List.of(1), List.of(2)
                , List.of(3), List.of());
        System.out.println(rooms);
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(rooms.get(0));
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        while (queue.size() != 0) {
            List<Integer> integers = queue.poll();
            integers.forEach(r -> {
                if (visited[r] == false) {
                    visited[r] = true;
                    queue.add(rooms.get(r));
                }
            });
        }
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
