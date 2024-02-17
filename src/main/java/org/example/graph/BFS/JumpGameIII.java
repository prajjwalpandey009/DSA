package org.example.graph.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class JumpGameIII {
    public static void main(String[] args) {
        System.out.println(canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }

    public static boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[arr.length];
        if (arr[start] == 0) {
            return true;
        }
        visited[start]=true;

        if (start + arr[start] <= arr.length - 1) {
            queue.add(start + arr[start]);
        }
        if (start - arr[start] >= 0) {
            queue.add(start - arr[start]);
        }

        while (queue.size() != 0) {
            int nextIndex = queue.poll();
            if (arr[nextIndex] == 0) {
                return true;
            }
            if (nextIndex + arr[nextIndex] <= arr.length - 1 && visited[nextIndex + arr[nextIndex]]==false) {
                visited[nextIndex + arr[nextIndex]] = true;
                queue.add(nextIndex + arr[nextIndex]);
            }
            if (nextIndex - arr[nextIndex] >= 0 && visited[nextIndex - arr[nextIndex]]==false) {
                visited[nextIndex - arr[nextIndex]]=true;
                queue.add(nextIndex - arr[nextIndex]);
            }
        }
        return false;
    }
}
