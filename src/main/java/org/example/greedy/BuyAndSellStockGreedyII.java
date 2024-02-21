package org.example.greedy;

//Algo
//We have to just find out that increasing point where value is higher than the
//previous one and added the profit
//and if value is decreasing the sold one same day and profit would be 0


public class BuyAndSellStockGreedyII {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
