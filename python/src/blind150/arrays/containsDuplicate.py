from typing import List
from src.utils.logging_util import get_logger

logger = get_logger(__name__)
class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        logger.info("Checking for duplicates in list: %s", nums)
        seen = set()
        for num in nums:
            if num in seen:
                logger.warning("Duplicate found: %s", num)
                return True
            seen.add(num)
        logger.info("No duplicates found.")
        return False

# Driver code
if __name__ == "__main__":
    solution = Solution()  # Create an instance of the Solution class
    nums = [1, 2, 3, 4, 5, 3]  # Example input list
    result = solution.hasDuplicate(nums)  # Call the method
