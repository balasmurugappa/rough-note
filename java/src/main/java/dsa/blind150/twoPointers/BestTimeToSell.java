package dsa.blind150.twoPointers;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

public class BestTimeToSell {
    private static final Logger logger = LoggerUtil.getLogger();

    public int maxProfit(int[] prices) {
        int left = 0, right = 0, maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        }
        logger.info("Max profit calculated: {}", maxProfit);
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToSell solution = new BestTimeToSell();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {5,1,5,6,7,1,10};

        logger.info("Max profit for prices1: {}", solution.maxProfit(prices1));
        logger.info("Max profit for prices2: {}", solution.maxProfit(prices2));
        logger.info("Max profit for prices3: {}", solution.maxProfit(prices3));
    }
}