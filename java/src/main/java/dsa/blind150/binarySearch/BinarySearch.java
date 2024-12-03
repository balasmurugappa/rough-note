package dsa.blind150.binarySearch;

import dsa.utils.LoggerUtil;
import org.slf4j.Logger;

public class BinarySearch {
    private static final Logger logger = LoggerUtil.getLogger();

    public static int binarySearch(int[] arr, int target) {
        logger.info("binarySearch invoked with target: {}", target);
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            logger.debug("Low: {}, High: {}, Mid: {}, Mid Value: {}", low, high, mid, arr[mid]);

            if (arr[mid] == target) {
                logger.info("Target {} found at index: {}", target, mid);
                return mid;
            } else if (arr[mid] < target) {
                logger.debug("Target {} is greater than {}, moving to the right half.", target, arr[mid]);
                low = mid + 1;
            } else {
                logger.debug("Target {} is less than {}, moving to the left half.", target, arr[mid]);
                high = mid - 1;
            }
        }
        logger.info("Target {} not found in the array.", target);
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        logger.info("Starting binary search tests.");

        // Test cases with expected results for clarity
        int[] testTargets = {5, 10, 1};
        String[] testDescriptions = {
                "Searching for target in the middle of the array",
                "Searching for a target not present in the array",
                "Searching for the smallest element"
        };

        // Execute test cases
        int testCaseNumber = 1;
        for (int target : testTargets) {
            logger.info("Test Case {}: {}", testCaseNumber, testDescriptions[testCaseNumber - 1]);
            int result = binarySearch(arr, target);
            logger.info("Test Case {} Result: Target {} found at index: {}", testCaseNumber, target, result);
            testCaseNumber++;
        }
    }
}
