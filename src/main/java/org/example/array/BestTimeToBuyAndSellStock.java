package org.example.array;

//Algo
//Consider every day as the potential day for selling and calculate the profit
//maintain one least so far price
//compare and lest so far with current price and update accordingly
// maintain on max profit variable also

//Question is like choose a day to buy and choose a day to sell and maximize profit

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{6, 0, 8, 2, 1, 5}));
    }

    public static int maxProfit(int[] prices) {

        int lpsf = Integer.MAX_VALUE;

        //profit if sell today
        int pist = 0;

        int op = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lpsf) {
                lpsf = prices[i];
            }
            pist = prices[i] - lpsf;
            if (pist > op) {
                op = pist;
            }
        }
        return op;
    }
}
