// 121. Best Time to Buy and Sell Stock --- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description
// See bottom for problem statement
public class P_0121 {

    /**
     * Double for loop checking all combinations for the max profit
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null) { return 0; }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int dayProfit = prices[j]-prices[i];
                if (dayProfit > maxProfit) {
                    maxProfit = dayProfit;
                }
            }
        }

        return maxProfit;
    }

    /**
     * A sliding window on the minimum buy price while going through the array.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int maxProfit2(int[] prices) {
        if (prices == null) { return 0; }

        int maxProfit = 0;
        int minBuy = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minBuy) {
                minBuy = price;
            } else if (price-minBuy > maxProfit) {
                maxProfit = price-minBuy;
            }
        }

        return maxProfit;
    }
}

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.



Constraints:

    1 <= prices.length <= 105
    0 <= prices[i] <= 104


*/
