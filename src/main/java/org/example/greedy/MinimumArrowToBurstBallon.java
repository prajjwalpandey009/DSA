package org.example.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumArrowToBurstBallon {
    public static void main(String[] args) {
        int[][] grid = {
                {-2147483646, -2147483645},
                {2147483646, 2147483647}
        };
        System.out.println(findMinArrowShots(grid));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(n -> n[1]));

        int count = 0;
        int previousTime = points[0][1];
        int ans = 0;
        while (count <= points.length - 1) {
            int startTime = points[count][0];
            if (count == 0) {
                ans++;
            } else {
                if (previousTime >= startTime) {

                } else {
                    previousTime = points[count][1];
                    ans++;
                }
            }
            count++;
        }

        return ans;
    }
}
