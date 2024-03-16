package org.example.greedy;

import java.util.Arrays;

public class CanCompleteCircuit {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int start = 0;
        int current = 0;
        for (int i = 0; i < gas.length; i++) {

            //if difference is positive then only we can move forward
            current += gas[i] - cost[i];
            if (current < 0) {
                start = i + 1;
                current = 0;
            }
        }
        return start;
    }
}
