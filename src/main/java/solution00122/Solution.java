package solution00122;

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        int currentProfit = 0;

        for (int i : prices) {
            if (i < minPrice) {
                minPrice = i;
            } else if ((i - minPrice) > currentProfit) {
                currentProfit = i - minPrice;
            }

            if ((i - minPrice) < currentProfit) {
                profit += currentProfit;
                minPrice = i;
                currentProfit = 0;
            }
        }

        if (currentProfit > 0) {
            profit += currentProfit;
        }

        return profit;
    }
}
