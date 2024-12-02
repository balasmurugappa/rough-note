from typing import List
from src.utils.logging_util import get_logger

logger = get_logger(__name__)

class BestTimeToSell:
    def maxProfit(self, prices: List[int]) -> int:
        left, right, maxProfit = 0, 0, 0

        while right < len(prices):
            if prices[left] < prices[right]:
                profit = prices[right] - prices[left]
                maxProfit = max(profit, maxProfit)
            else:
                left = right
            right += 1

        logger.info(f"Max profit calculated: {maxProfit}")
        return maxProfit

if __name__ == "__main__":
    solution = BestTimeToSell()

    test_cases = [
        ([7, 1, 5, 3, 6, 4], 5),
        ([7, 6, 4, 3, 1], 0),
        ([1, 2, 3, 4, 5], 4),
        ([7, 6, 5, 4, 3], 0)
    ]

    for prices, expected in test_cases:
        logger.info(f"Checking prices: {prices}")
        result = solution.maxProfit(prices)
        logger.info(f"Max profit for {prices} is {result} (Expected: {expected})")