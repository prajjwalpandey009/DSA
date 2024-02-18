package org.example.greedy;

import java.util.Arrays;
import java.util.Comparator;

//Algo
//Combine workers difficulty and profit
//Then sort it by workers difficulty
//Iterate workers through difficulty and profit array
//check current profit and assign it to max

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        maxProfitAssignment(new int[]{13, 37, 58}, new int[]{4, 90, 96}, new int[]{34, 73, 45});
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] diffAndproFit = new int[difficulty.length][2];

        //combining difficulty and profit
        for (int i = 0; i < difficulty.length; i++) {
            diffAndproFit[i] = new int[]{difficulty[i], profit[i]};
        }

        //Sorted on the basis of difficulty
        Arrays.sort(diffAndproFit, Comparator.comparingInt(n -> n[0]));
        Arrays.sort(worker);

        int currentProfit = 0;
        int maximumProfit = 0;

        //check the worker
        for (int i = 0; i < worker.length; i++) {
            //Extracting difficulty level
            int difficultyLevel = worker[i];

            int count = 0;

            //comparing difficulty it can take from difficulty and profit array
            //and comparing profit it can make
            while (count < diffAndproFit.length && diffAndproFit[count][0] <= difficultyLevel) {
                currentProfit = Math.max(currentProfit, diffAndproFit[count][1]);
                count++;
            }
            maximumProfit += currentProfit;
            currentProfit = 0;

        }
        return maximumProfit;

    }
}
