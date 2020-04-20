package leetcode;
/*
121. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.
* */

/*
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
* */
public class n121 {

    public int maxProfit(int[] prices) {

        int buy = 0;
        int sell = 0;
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            buy = prices[i];
            for (int k = i + 1; k < prices.length; k++) {
                sell = prices[k];
                if (buy < sell && max < sell - buy) {
                    max = sell - buy;
                }
            }
        }

        return max;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if( min > prices[i]) {
                min = prices[i];
            } else if(prices[i] - min > max) {
                max = prices[i] - min;
            }
        }

        return max;

    }
}
