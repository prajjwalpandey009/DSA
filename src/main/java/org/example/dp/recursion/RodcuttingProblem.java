package org.example.dp.recursion;

import java.util.Arrays;

public class RodcuttingProblem {
    public static void main(String[] args) {
        System.out.println(minCost(7, new int[]{1, 3, 4, 5}));
    }

    public static int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = n;
        Arrays.sort(cuts);
        for (int i = 0; i < cuts.length; i++) {
            arr[i + 1] = cuts[i];
        }
        return cutTheStick(arr, 0, arr.length-1);
    }

    private static int cutTheStick(int[] arr, int l, int r) {

        if (r - l < 2) {
            return 0;
        }

        int res = Integer.MAX_VALUE;

        for (int i = l + 1; i <= r - 1; i++) {
            //Try to cut with every possible cut
            int cost = (arr[r] - arr[l]) + cutTheStick(arr, l, i)
                    + cutTheStick(arr, i, r);
            res = Math.min(res, cost);
        }
        return res;
    }
}
