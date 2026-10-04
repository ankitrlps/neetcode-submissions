class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length < 2) return maxProfit;
        int i = 1;
        int buy = prices[0];
        while (i < prices.length) {
            if (buy >= prices[i]) {
                buy = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - buy);
            }
            i++;
        }

        return maxProfit;
    }
}
