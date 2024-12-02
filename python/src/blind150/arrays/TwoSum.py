from typing import List
from src.utils.logging_util import get_logger

logger = get_logger(__name__)

class TwoSum:
    def compute(self, nums: List[int], target: int) -> List[int]:
        targetMap = {}

        for i, n in enumerate(nums):
            diff = target - n
            logger.debug(f"Checking number: {n}, diff: {diff}, targetMap: {targetMap}")
            if diff in targetMap:
                logger.info(f"Found pair: {n} + {diff} = {target}, at indices {targetMap[diff]} and {i}")
                return [targetMap[diff], i]
            targetMap[n] = i
        logger.warning(f"No pair found for target {target}")
        return [-1, -1]

# Driver code
if __name__ == "__main__":
    two_sum = TwoSum()

    nums = [0, 6, 2, 7, 11, 15]
    target = 9
    logger.info(f"Input array: {nums}, target: {target}")
    result = two_sum.compute(nums, target)

    if result != [-1, -1]:
        logger.info(f"Indices of numbers that add up to {target}: {result}")
    else:
        logger.warning("No valid pair found.")