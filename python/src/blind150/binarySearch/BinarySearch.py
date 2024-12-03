from typing import List
from src.utils.logging_util import get_logger

logger = get_logger(__name__)


class BinarySearch:
    def searchTarget(self, target: int, nums: List[int]) -> int:
        logger.info("searchTarget method invoked with target: %d", target)
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + ((right - left) // 2)
            logger.debug("Left: %d, Right: %d, Mid: %d, Mid Value: %d", left, right, mid, nums[mid])

            if nums[mid] == target:
                logger.info("Target %d found at index: %d", target, mid)
                return mid
            elif nums[mid] < target:
                logger.debug("Target %d is greater than %d, moving to the right half.", target, nums[mid])
                left = mid + 1
            else:
                logger.debug("Target %d is less than %d, moving to the left half.", target, nums[mid])
                right = mid - 1

        logger.info("Target %d not found in the array.", target)
        return -1


# Driver code to test the BinarySearch class and searchTarget method
if __name__ == "__main__":
    # Test cases
    nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]

    test_cases = [5, 10, 1]
    for idx, target in enumerate(test_cases, start=1):
        logger.info("Test Case %d: Searching for target %d", idx, target)
        binary_search = BinarySearch()
        result = binary_search.searchTarget(target, nums)
        logger.info("Test Case %d Result: Target %d found at index: %d", idx, target, result)
