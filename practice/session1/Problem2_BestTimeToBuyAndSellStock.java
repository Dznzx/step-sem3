/*
 * Category C - Problem L2: Best Time to Buy and Sell Stock
 * Single-pass scan tracking the lowest price seen so far and the largest
 * profit achievable by selling on any later day.
 */
public class Problem2_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

    private static int maxProfit(int[] prices) {
        int lowestPriceSoFar = prices[0];
        int bestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - lowestPriceSoFar;
            bestProfit = Math.max(bestProfit, profitIfSoldToday);
            lowestPriceSoFar = Math.min(lowestPriceSoFar, prices[i]);
        }

        return bestProfit;
    }
}
