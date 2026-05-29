package com.haleluqe.algorithms;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] stockPrices = new int[]{7,1,5,3,6,4};
        System.out.println(calculateBestProfit(stockPrices));
    }

    /**
     * Description: You are given an array prices where prices[i] is the price of a given stock on the i^th day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
     * future to sell that stock.
     *
     * Solution Strategy (Sliding Window):
     * We use two pointers to represent the buying and selling days:
     * Left Pointer (left): Represents the day with the lowest buying price found so far.
     * Right Pointer (right): Iterates through the array representing the potential selling day.
     * If prices[left] < prices[right], we calculate the potential profit and update maxProfit.
     * If prices[left] > prices[right], it means we found a new historical minimum price. We move our left pointer to
     * the right position to start tracking profits from this new lower baseline.
     *
     * Why O(n)
     * Even though we are managing two pointers, the right pointer traverses the array exactly once.
     * The left pointer only jumps forward, never backward. This single-pass approach ensures optimal performance.
     */
    public static int calculateBestProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        //base case
        if (prices == null || prices.length < 2) return 0;

        while (right < prices.length) {
            int leftPrice = prices[left];
            int rightPrice = prices[right];
            if (leftPrice > rightPrice) {
                left = right;
            }
            else  {
                maxProfit = Math.max(maxProfit, rightPrice - leftPrice);
            }
            right++;
        }

        return maxProfit;
    }
}
