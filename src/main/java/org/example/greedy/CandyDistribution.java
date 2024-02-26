package org.example.greedy;

import java.util.Arrays;

public class CandyDistribution {
    public static void main(String[] args) {
        candy(new int[]{1, 2, 87, 87, 87, 2, 1});
    }

    public static int candy(int[] ratings) {

        //let check the left neighbour first and increase the candy count
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        //let check the candy count from right side and increase the candy count
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                if (candies[i] > candies[i + 1]) {
                    // if candies already greater than right neighbour then nothing to do with it
                } else {
                    candies[i] = candies[i+1] + 1;
                }
            }
        }

        int sum = 0;
        sum = Arrays.stream(candies).sum();
        return sum;
    }
}
