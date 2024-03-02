package org.example.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthofPairChain {
    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][]{{8, 9}, {8, 10}, {-3, 7}, {-9, 9}, {8, 10}, {1, 10},
                {-7, 3}, {-3, 6}, {9, 10}, {-8, 0}}));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(n -> n[1]));
        return solveFindLongestChain(pairs, null);
    }

    private static int solveFindLongestChain(int[][] pairs, Integer prev) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (prev == null) {
                count++;
                prev = pairs[i][1];
            } else {
                if (prev < pairs[i][0]) {
                    count++;
                    prev = pairs[i][1];
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
