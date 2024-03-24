package org.example.heap;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduling {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] count = new int[27];
        for (char task : tasks) {
            count[task - 'A'] += 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i : count) {
            if (i != 0) {
                pq.add(i);
            }
        }

        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time += 1;

            //Add to queue
            if (!pq.isEmpty()) {
                int task = pq.poll();
                //add to Queue
                task -= 1;
                if (task > 0) {
                    queue.add(new int[]{task, time + n});
                }
            }

            //Add to pq
            if (!queue.isEmpty()) {
                int[] val = queue.peek();
                if (time >= val[1]) {
                    queue.poll();
                    pq.add(val[0]);
                }
            }

        }

        return time;
    }
}
