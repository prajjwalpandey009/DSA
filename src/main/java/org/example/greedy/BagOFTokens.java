package org.example.greedy;

import java.util.Arrays;

public class BagOFTokens {
    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int i = 0;
        int j = tokens.length - 1;
        int currantMax = 0;
        int max = Integer.MIN_VALUE;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                currantMax++;
                i++;
            } else {
                if (max >= 1) {
                    power += tokens[j];
                    currantMax--;
                    j--;
                } else {
                    i++;
                }
            }
            max = Math.max(max, currantMax);
        }

        return Math.max(max, 0);
    }
}
